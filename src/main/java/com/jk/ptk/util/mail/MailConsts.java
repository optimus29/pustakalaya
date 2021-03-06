package com.jk.ptk.util.mail;

/**
 * Parameter names, template names and property names used to send mails.
 *
 * @author Jitendra
 *
 */
public final class MailConsts {
	// prevent instantiation
	private MailConsts() {
	}
	public static final String PARAM_LOGIN_PAGE = "loginPage";

	public static final String PARAM_NAME_OF_USER = "userName";
	public static final String PARAM_EMAIL_OF_USER = "userEmail";

	public static final String PARAM_SUBJECT_PARAMETERS = "subjectParameters";

	public static final String SUBJECT_COMPLETE_REGISTRATION = "registration.subject";
	public static final String TPARAM_COMPLETE_REGISTRATION_LINK = "registerationLink";
	public static final String TPARAM_COMPLETE_REGISTRATION_EXPIRE = "registrationExpires";
	public static final String TEMPLATE_COMPLETE_REGISTRATION = "completeRegistration";
	
	
	public static final String SUBJECT_ACCOUNT_CREATION_COMPLETE = "account.creation.complete.subject";
	public static final String TEMPLATE_ACCOUNT_CREATION_COMPLETE = "accountCreationComplete";

	public static final String SUBJECT_BOOK_ASSIGNED = "book.assigned.subject";
	public static final String TEMPLATE_BOOK_ASSIGNED = "bookAssigned";
	public static final String TPARAM_BOOK_ASSIGNED_MAIL = "mail";
}
