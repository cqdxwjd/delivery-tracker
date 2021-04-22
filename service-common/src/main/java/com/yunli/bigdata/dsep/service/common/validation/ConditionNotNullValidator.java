package com.yunli.bigdata.dsep.service.common.validation;

import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

/**
 * 自定义条件NotNull校验
 *
 * @author zhangws
 */
public class ConditionNotNullValidator implements ConstraintValidator<ConditionNotNull, String> {

  @Override
  public void initialize(ConditionNotNull constraintAnnotation) {

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Map<String, Object> attributes =
        ((ConstraintValidatorContextImpl) context).getConstraintDescriptor().getAttributes();
    String type = (String) attributes.get("type");
    String message = (String) attributes.get("message");
    int checkCount = Integer.parseInt(attributes.get("checkCount").toString());

    if (null == value) {
      return false;
    }
    if (value.trim().length() >= 32) {
      return true;
    }
    return false;
  }
}
