package com.yunli.web.util;

import com.yunli.bigdata.dsep.foundation.CustomHttpHeaderNames;
import com.yunli.common.json.JSONObject;
import com.yunli.web.config.AKSK;
import com.yunli.web.dto.CreateTableColumnDto;
import com.yunli.web.dto.CreateTableDto;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

/**
 * 数据中台 2.x 根据包含给定格式表字段信息的 excel 文件批量创建表
 *
 * @author wangjingdong
 * @date 2021/6/24 15:44
 * @Copyright © 云粒智慧 2018
 */
public class TableUtils {

    public static Workbook readExcel(String fileName) {
        Workbook wb = null;
        if (fileName == null) {
            return null;
        }
        String extString = fileName.substring(fileName.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            if (".xls".equals(extString)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static HashMap<String, CreateTableDto> getCreateTables(String prefix, String fileName, String responsibleId, String responsibleOrganizationId) throws Exception {
        HashMap<String, CreateTableDto> map = new HashMap<>();

        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        wb = readExcel(fileName);
        if (wb != null) {
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i < rownum; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    String name = prefix + row.getCell(0).toString();

                    // 对字段名称做一些特殊处理
                    String columnName = row.getCell(3).toString().trim();
                    if (columnName.contains("（")) {
                        columnName = columnName.replace("（", "(");
                    }
                    columnName = columnName.replace(":", "").replace("(", "_").replace(")", "_").replace("-", "and").toLowerCase();
                    if (columnName.length() > 63) {
                        columnName = columnName.substring(0, 32);
                    }

                    // 对字段中文名做特殊处理
                    String columnNameCn = null;
                    if (row.getCell(4) == null) {
                        columnNameCn = columnName;
                    } else {
                        columnNameCn = row.getCell(4).toString().trim();
                    }
                    if (columnNameCn.length() > 127) {
                        columnNameCn = columnNameCn.substring(0, 64);
                    }

                    // 对字段描述做特殊处理
                    String columnDescription = null;
                    if (row.getCell(6) == null) {
                        columnDescription = columnNameCn;
                    } else {
                        columnDescription = row.getCell(6).toString().trim();
                    }

                    CreateTableDto createTableDto = map.get(name);
                    if (createTableDto == null) {
                        ArrayList<CreateTableColumnDto> createTableColumnDtos = new ArrayList<>();
                        createTableColumnDtos.add(new CreateTableColumnDto(
                                columnDescription,
                                columnNameCn,
                                0,
                                columnName,
                                row.getCell(7).toString().trim().toLowerCase().equals("true") || row.getCell(7).getNumericCellValue() == 1,
                                row.getCell(5).toString().trim()
                        ));
                        map.put(name, new CreateTableDto(
                                createTableColumnDtos,
                                row.getCell(1).toString().trim(),
                                row.getCell(1).toString().trim(),
                                name,
                                responsibleOrganizationId,
                                responsibleId,
                                null)
                        );
                    } else {
                        createTableDto.getColumns().add(new CreateTableColumnDto(
                                columnDescription,
                                columnNameCn,
                                0,
                                columnName,
                                row.getCell(7).toString().trim().toLowerCase().equals("true") || row.getCell(7).getNumericCellValue() == 1,
                                row.getCell(5).toString().trim()
                        ));
                    }
                } else {
                    break;
                }
            }
        }

        for (CreateTableDto value : map.values()) {
            List<CreateTableColumnDto> columns = value.getColumns();
            for (CreateTableColumnDto column : columns) {
            }
        }

        return map;
    }

    /**
     * 数据中台 2.x 快速建表 demo
     *
     * @param args
     * @author wangjingdong
     * @date 2021/6/24 16:39
     */
    public static void main(String[] args) throws Exception {
        String prefix = "gansu_";
        String address = "http://172.30.1.233:30004";
        String userId = "c14b130c-7d61-4f5e-a2f5-ef28e4e5e11d";
//        String userId = "2a7dc9f4-6c8f-44da-b451-b21ad114f586";
        String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChWFL1XjuykiodL+EinLgiTuvuFVMGOF64A/WDxRhhZzhRDlsTC1zmEOypjllnGKzf98uTRtYJSx7QPKG/qTutqn/AEi672zc9DSHPDZeeAULoh0VfjXLxvMRvWnbtg/d2jtimEb/Y6h+W1gG8QAL4sOASSANR8uCIL7xDAtww3G4/ejDUGK9isMxX3vehWWqKsu8I7Tu+yiZlfTXkl5hxNZOuhDPYKqu2imzw0lwkL/e+YU34sRu3+E1tbMA1T0NOrv+TPA7Pjna0XVxhQlrmrJdylMhZuAC0dCuLIDMMmFMiqr5fkIWQPbtnOfbrHdYxdH1tDSQ/ejcau5w37Ss3AgMBAAECggEAGGrDczqlkiqokO40BgbtntOOxOMZQ3G4c+S1fRGQ1PzH+wxPIByyHGcnSamvQfjsAKEBf/JSZemmaiEi4Vx9GZUZ7DlUNT3BqE2adjk6XsEWHRaLmyBO6uKEX82y/dLg2mJXyxoYjH0x9qPAc3rEeFpcLqgTSI2XCUUgGowOQp571Thzi+jgsivdTK5CdUHsB0782x8ifqx5OH4D0o7furL/RWeBcIq+28nn+dTVI8hbapHQqcFhX6Pf+ucWZrdtyjQLHw/qMnVkOLLCx1IZiw15MOUYfPdHofW/ZlWs2k9ta2lxiVj5TaOgAh8X/ExWLk2K1vpHPgbIikO7lfc+8QKBgQDLplsSV6YPxp3RArvNja3NqMC4kcKOiVwaRpVvmU7EJX9apGOwbpM15IAj1q4ymCz6n7dT25LXRAhMrLbZuj0+78WSWuld4MeLY3XKeblTvdG0iYKtVNleJDCR9DBqMEfXt/TxaFuwXASsTLC++kkJf2+0Hln6ghx2bS0TSvg0WwKBgQDK0gDL4SdkhohjB5xLfVVeYvpqp2IUDBsx1RqQVTrU+lWwH8nrVDb94r8Tk1T5DodEsohxEJ/QEU4Ez5olGtlSVNl+EoIMgLoMJWmSKRL+qeMWk2uVrKbDXSxIYk4EpAmpcXNWQ2OjbF12aI/gCrziuNcR+sh6UNp1vtfyc5GrVQKBgHHggVadan+x2bfxpmDIE+NHtRTAdSHNT5Jl29Q+zxvBuBhQimozOuBM+RaRSnGCRMyUmSgsRU1YfqeZgNn5WZwi6cDwU0SqmAqqwEhLjsV0BJrGtisEolQROpOzD4uhmdrXxAFmELdqjTZn4AG65TKJb0YyHrCFJzNV03nRVz+3AoGABAt6HpbH7VZNhAQT1uGSAUbiDZx29UVkiXLhi71XZgX0DYYkxb+xNRD/lIlcqXbjtbgFxpN5THH751aokVLewKiWidAerdcnXrSkTVjqWw/SSpH4FE0UKlNCXdMwESGgW7O6hB7l7s1rc8AUFnjAWZksGNyygNX59V0v+1LYtd0CgYBZ7mIeLLi6JGehPTslmX+gNchezekUZVDuBWvg5MF9UHx3I2QzB2pEfRPIV21ZEeTvV5mqAZMxBVznhwpomk2iRLg3l7Cbj7iLZAjbgaUhMlH4IFJR9UlonKlM8Y/9zG0xA7JcmT86yPSSh5B+rrjx/60cJ1fN8lj9LLEG/GIyLw==";
//        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQClgK2ZzGtD5TS6YlpRv9F3nwVJ5QlcLb1UFMcmXjZMuvxMHmXH+izJOi03Y/6edim8VAyoGBtFlhg2lmQzED5IgHPCHJbcgH1A93i12qIdtDovnm2xPIk/CVUWHbP2AmCgBbW+DPp2MvsV0rf/xRN5rGPMQlGyUTE0qR7YBRlYHyvoeBRd5RDCm7HFnT/X8drWxRlAE9rsgzTUDW/qTajAj/gpw6LXDDaHoyCwmS2rDL2vFzdYNiVqnIqzx5+IKxdyK4EXdJuJhp4X65fm3t3UNOorws0CM+g7kNl8yn8/YdYUX+De73Eu/rHDbZwTlHCMBYldR+RGx3AtZg0Psog3AgMBAAECggEADmBwNCUCyGIXw30ZtXJBQu/oaLPhrUU35h7r8dRLST0Q/5fAZa/AxjYsiVxBWQiQtZBjjRKTA+d28P79c0Yc8vVdmOYc4Mi0mLkmnj2Aya3HRC2x/6xvi69G2eX4pQ0t0ZjNYdYEx9HD5/BnFWvMNkyYWr0EFcZhzN5IFKHUwsfGlV+218o9dNNLcSKolJ98jllgWDFq4NpPiiPClfFVU0Vmfzv5vBiJsPB+rY+gFp+WltIl2Zux9cepKPiMune3DSzoix21MOQXyl5SdgwP8iF5G9xUyPCtV/+Stlx/v/Nt8gdaUq3Sl1JGOP+TsO/IBwEexm6Ydn6yR/3c1oKVSQKBgQDbrRLwseU0V0bqrAOM8Oeyj/xD9nL/hujURG55A49IzKOufcce29dH1hp8F7OMaJLeqqhhF2BjZM5g38h8eEoSgA09ZlQycNrhN1bFHrdqMsL+qwrEuFT1nW5MpdzNQ45RT70vqNCJYEi+/IAc8iS1mYqV6q5MJCTck09tuwFvpQKBgQDA3m8RQerZoNqLRh0bTewcaZenCRDSqTnE9AUZFwraPLzbhJLX4y6OfI290k6ODB/4uGecqS4X7yikBXlTwtRnswfWmYHi4uwCvGwirCkpJ+EGG8rBOkqWUGPPnoedMEATKNrLvaVvpddhNHpCRDhU+HROQdaqNUoXMNuh95cRqwKBgQCNboatNLuO0Uo1OH4otclWq2ENGJS9c0xfrZc6jlIn2qjfZNdYRM370BrJHjFZCtLUTSePKw/Brls4/5sCmCeIda0QhNtchlBFg+13h+kqlHf6ooCSWuNIJw2mh3r7JK1yKFZzYsqwR69OVx7chAGicbJKBwgkuXiKEsWmrimkiQKBgArfv6VacRJKFmhJ0LRMZWaIsYsyYKdv8RjgpTTv7qW1TPSXeewAHAzeiuNL6y/pERhl1Tmo9DdXPZRZ1qhZUL50Apof14niP2o8E2C1EjEG1ZIRmRHh5nipGaeICZ9cLBCoegWIsL4lvIn3enkn/YEU7QHIhoDcNkwubgOowPS3AoGAFuz1NEZLCyJqCZQOvW/L79ekSzZAZOz0fEzegcrdCc7/jeJ+6jSxlIcoyFBmTNO8X0BeX2IV89N3nA6YpHdzLlKB6AWxGWp43FVKJ1nD/SGf5/Pfq2m1e2/0VlYjuHNrZAKLvDo61aZGy048KLe2I93cw8r4dEdIooCeCc3XP1M=";
        HttpHeaders requestHeaders = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        String token = AKSK.getToken(
                new RestTemplate(),
                address,
                userId,
                AKSK.getCipherText(privateKey)
        );
        requestHeaders.set(CustomHttpHeaderNames.X_TOKEN, token);

        HashMap<String, CreateTableDto> tables = getCreateTables(
                prefix,
                "/Users/wangjingdong/Downloads/目录对应已有表关系0324 - stg(1).xls",
//                "79885660-c36f-47a7-ad45-64f967cab9c9",
                "b8fee4d3-4f4e-4078-b55d-479ae6931d83",
//                "7935d015-5fc2-4a53-b72e-6c4fe2558bb3"
                "cbc8aea8-b32b-4a85-b9c2-b87bbb63a1ab"
        );

        ArrayList<String> errors = new ArrayList<>();
        for (CreateTableDto value : tables.values()) {
            HttpEntity<Object> request = new HttpEntity<>(value, requestHeaders);
            String treeBody = restTemplate.exchange(address + "/x-data-resource-service/resources/tables",
                    HttpMethod.POST, request, String.class).getBody();
            JSONObject jsonObject = new JSONObject(treeBody);
            int code = jsonObject.getInt("code");
            if (code != 200 && code != 1100) {
                errors.add(value.getName() + "--------" + treeBody);
            }
        }
        System.out.println(errors);
    }
}
