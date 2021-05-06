package com.yunli.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgramStat {
    String type;
    int oozieSchduleCount;
    int runningOozieSchduleCount;
    int suspendedOozieSchduleCount;
    int oozieJobCount;
    int hiveScriptCount;
    int shellScriptCount;
}
