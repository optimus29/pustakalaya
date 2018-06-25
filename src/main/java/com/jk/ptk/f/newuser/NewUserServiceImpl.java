package com.jk.ptk.f.newuser;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.ptk.app.App;
import com.jk.ptk.app.DataValidation;
import com.jk.ptk.app.ValidationFailedException;
import com.jk.ptk.model.UserRole;
import com.jk.ptk.util.MailConsts;
import com.jk.ptk.util.UuidUtils;
import com.jk.ptk.util.mail.MailTemplateService;

/**
 * Uses ORM framework to store and retrieve the object. An mail is sent to
 * user's email address with a link to complete registration process.
 * 
 * @author Jitendra
 *
 */
@Service
public class NewUserServiceImpl implements NewUserService, DataValidation<NewUser> {
	@Autowired
	private NewUserRepository repo;

	@Autowired
	private MailTemplateService mailService;

	@Override
	public void addNewUser(NewUser newUser) throws ValidationFailedException {
		// set required fields
		newUser.setId(UuidUtils.generate());
		newUser.getRole().setId(UserRole.DEFAULT_USER_ROLE);
		// validate fields
		validate(newUser);
		// store into db
		//repo.saveNewUser(newUser);
		// notify user
		sendMail(newUser);
	}

	private boolean sendMail(NewUser newUser) {
		String registrationUri = App.getUrl("/api/newUser/" + newUser.getId());
		Map<String, Object> params = new HashMap<>();

		params.put(MailConsts.PARAM_COMPLETE_REGISRATION_USER_NAME, newUser.getFirstName());
		params.put(MailConsts.PARAM_COMPLETE_REGISTRATION_EXPIRE, App.registrationLinkExpireDuration());
		params.put(MailConsts.PARAM_COMPLETE_REGISTRATION_LINK, registrationUri);

		return mailService.sendMail(MailConsts.TEMPLATE_COMPLETE_REGISTRAION, newUser.getEmail(), MailConsts.PROP_SUBJECT_COMPLETE_REGISTRAION,
				params, new Locale(newUser.getLocaleStr()));
	}

	@Override
	public NewUser getNewUser(String id) {
		return repo.findNewUser(id);
	}

	@Override
	public void validate(NewUser obj) throws ValidationFailedException {
		// TODO Auto-generated method stub
	}

}