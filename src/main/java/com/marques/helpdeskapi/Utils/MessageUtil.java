package com.marques.helpdeskapi.Utils;

public  abstract class MessageUtil {
	
	public static final String OBJECT_NOT_FOUND = "Objeto não encontrado!";
	public static final String CPF_ALREADY_REGISTERED = "CPF já cadastrado!";
	public static final String EMAIL_ALREADY_REGISTERED = "Email já cadastrado!";
	public static final String TECHNICIAN_INCIDENTS = "O técnico possui incidentes atribuído ao seu nome e não pode ser deletado!";
	public static final String CLIENT_INCIDENTS = "O cliente possui incidentes abertos em seu nome e não pode ser deletado!";
	
	
	//VALIDATORS
	public static final String FIELD_NAME_IS_REQUIRED = "O campo NOME é obrigatório!";
	public static final String FIELD_CPF_IS_REQUIRED = "O campo CPF é obrigatório!";
	public static final String FIELD_EMAIL_IS_REQUIRED = "O campo E-MAIL é obrigatório!";
	
	public static final String FIELD_PRIORITY_IS_REQUIRED = "O campo PRIORIDADE é obrigatório!";
	public static final String FIELD_STATUS_IS_REQUIRED = "O campo STATUS é obrigatório!";
	public static final String FIELD_TITLE_IS_REQUIRED = "O campo TÍTULO é obrigatório!";
	public static final String FIELD_DESCRIPTION_IS_REQUIRED = "O campo DESCRIÇÃO é obrigatório!";
	public static final String FIELD_TECHNICIAN_IS_REQUIRED = "O campo TÉCNICO é obrigatório!";
	public static final String FIELD_CLIENT_IS_REQUIRED = "O campo CLIENTE é obrigatório!";
	
	public static final String FIELD_PASSWORD_IS_REQUIRED = "O campo SENHA  é obrigatório!";
	
	public static final String VALIDATION_ERRORS = "Erro na validação dos campos!";

}
