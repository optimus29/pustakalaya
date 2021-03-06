package com.jk.ptk.f.newuser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.ptk.app.response.ResponseCode;
import com.jk.ptk.f.user.UserService;
import com.jk.ptk.util.LocaleUtil;
import com.jk.ptk.util.PatternStore;
import com.jk.ptk.validation.DataValidator;
import com.jk.ptk.validation.ValidationException;

/**
 * This class is used to validate the fields of the type {@code NewUserV}.
 * 
 * @author Jitendra
 */
@Component("NewUserValidator")
class NewUserFieldValidator implements DataValidator<NewUserV> {
	private static final int FIRST_NAME_MAX_LEN = 30;
	private static final int LAST_NAME_MAX_LEN = 30;

	private UserService userService;
	
	@Autowired
	public NewUserFieldValidator(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void validate(NewUserV newUser) throws ValidationException {
		ResponseCode errorCode;
		Map<String, ResponseCode> errorMap = new HashMap<>();

		errorCode = validateFirstName(newUser.getFirstName(), true);
		if (errorCode != null) {
			errorMap.put(NewUserV.FIELD_FIRST_NAME, errorCode);
		}

		errorCode = validateLastName(newUser.getLastName(), true);
		if (errorCode != null) {
			errorMap.put(NewUserV.FIELD_LAST_NAME, errorCode);
		}

		errorCode = validateEmail(newUser.getEmail(), true);
		if (errorCode != null) {
			errorMap.put(NewUserV.FIELD_EMAIL, errorCode);
		}

		errorCode = validateLocaleStr(newUser.getLocale(), true);
		if (errorCode != null) {
			errorMap.put(NewUserV.FIELD_LOCALE, errorCode);
		}

		// if there are errors throw exception
		if (errorMap.size() > 0) {
			throw new ValidationException(errorMap);
		}
	}

	private ResponseCode validateFirstName(String value, boolean mandatory) {
		if (value == null || value.isEmpty()) {
			if (mandatory)
				return ResponseCode.EMPTY_VALUE;
			else
				return null;
		}

		if (value.length() > FIRST_NAME_MAX_LEN)
			return ResponseCode.LENGTH_TOO_LONG;

		return null;
	}

	private ResponseCode validateLastName(String value, boolean mandatory) {
		if (value == null || value.isEmpty()) {
			if (mandatory)
				return ResponseCode.EMPTY_VALUE;
			else
				return null;
		}

		if (value.length() > LAST_NAME_MAX_LEN)
			return ResponseCode.LENGTH_TOO_LONG;

		return null;
	}

	private ResponseCode validateLocaleStr(String value, boolean mandatory) {
		if (value == null || value.isEmpty()) {
			if (mandatory)
				return ResponseCode.EMPTY_VALUE;
			else
				return null;
		}

		Matcher m = PatternStore.LOCALE.matcher(value);
		if (!m.matches())
			return ResponseCode.INVALID_FORMAT;

		if (!LocaleUtil.isSupported(value))
			return ResponseCode.UNSUPPORTED_VALUE;

		return null;
	}

	private ResponseCode validateEmail(String value, boolean mandatory) {
		// check if value is empty
		if (value == null || value.isEmpty()) {
			if (mandatory)
				return ResponseCode.EMPTY_VALUE;
			else
				return null;
		}

		// match email with pattern
		Matcher m = PatternStore.EMAIL.matcher(value);
		if (!m.matches())
			return ResponseCode.INVALID_FORMAT;

		// check whether it already exists
		if (userService.doesUserExist(value))
			return ResponseCode.VALUE_ALREADY_EXIST;

		return null;
	}

}
