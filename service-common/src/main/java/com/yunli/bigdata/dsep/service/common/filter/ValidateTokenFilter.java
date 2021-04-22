package com.yunli.bigdata.dsep.service.common.filter;

import com.yunli.bigdata.dsep.foundation.CustomHttpHeaderNames;
import com.yunli.bigdata.dsep.foundation.Result;
import com.yunli.bigdata.dsep.foundation.util.JsonUtil;
import com.yunli.bigdata.dsep.service.common.ExpiredTokenException;
import com.yunli.bigdata.dsep.service.common.InvalidSignatureException;
import com.yunli.bigdata.dsep.service.common.InvalidTokenStringException;
import com.yunli.bigdata.dsep.service.common.constant.CommonMessageCode;
import com.yunli.bigdata.dsep.service.common.util.TokenUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhengyangyong
 */
public class ValidateTokenFilter extends GenericFilterBean {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    String token = httpRequest.getHeader(CustomHttpHeaderNames.X_TOKEN);
    //X_TOKEN header需要标记为必须
    if (!StringUtils.isEmpty(token)) {
      try {
        TokenUtil.validateToken(TokenUtil.parseToken(token));
      } catch (ExpiredTokenException e) {
        setResponseFailed(servletResponse, CommonMessageCode.ERROR_1104);
        return;
      } catch (InvalidSignatureException | InvalidTokenStringException e) {
        setResponseFailed(servletResponse, CommonMessageCode.ERROR_401);
        return;
      }
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

  private void setResponseFailed(ServletResponse servletResponse, CommonMessageCode commonMessage) throws IOException {
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
    httpResponse.setStatus(commonMessage.getCode());
    httpResponse.setContentType("application/json; charset=utf-8");
    PrintWriter writer = httpResponse.getWriter();
    writer.append(JsonUtil.writeValueAsString(
        Result.error(commonMessage.getCode(), commonMessage.getMessage())));
  }
}
