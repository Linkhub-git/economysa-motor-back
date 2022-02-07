package com.economysa.motor.util;

/**
 * @author QuickDev
 * @version 1.0
 */
public class ConstantMessage {

	public static final String ACCESS_DENIED = "access_denied";

	public static final String ERROR_NOT_FOUND = "Resource Not Found";
	public static final String ERROR_CONFLICT = "Conflict";
	public static final String ERROR_BAD_REQUEST = "Bad Request";
	public static final String ERROR_MESSAGE_NOT_READABLE = "Message Not Readable";
	public static final String ERROR_VALIDATION_FAILED = "Validation Failed";
	public static final String ERROR_INPUT_VALIDATION_FAILED = "Input Validation Failed";

	public static final String SUCCESSFUL_OPERATION = "Operación realizada exitosamente";

	public static final String USER_NOT_FOUND_EMAIL = "El correo ingresado no se encuentra registrado";
	public static final String USER_ALREADY_EXISTS = "El correo ingresado ya se encuentra registrado";

	public static final String ACTIVE = "Activo";
	public static final String INACTIVE = "Inactivo";

	public static final String PROVIDER_NOT_FOUND = "No se encontró el proveedor";
	public static final String PROVIDER_ALREADY_EXISTS = "Ya existe el proveedor para el ID registrado";

	public static final String PRODUCT_NOT_FOUND = "No se encontró el producto";
	public static final String PRODUCT_ALREADY_EXISTS = "Ya existe el producto para el ID registrado";

	public static final String MODALITY_NOT_FOUND = "No se encontró la modalidad";

	public static final String PROMOTION_TYPE_NOT_FOUND = "No se encontró el tipo de promoción";

	public static final String MECHANIC_NOT_FOUND = "No se encontró la mecánica";
	public static final String MECHANIC_ALREADY_EXISTS = "Ya existe una mecánica para el ID registrado";
	public static final String MECHANIC_ERROR_NULL_PERCENTAGE_DISCOUNT = "El porcentaje no puede estar vacío para una mecánica de tipo descuento";
	public static final String MECHANIC_ERROR_NULL_FACTOR_BONUS_QUANTITY = "El factor y la cantidad no pueden ser vacíos para una mecánica de tipo bonificación";

	public static final String MECHANIC_TARGET_NOT_FOUND = "No se encontró el target id";

	public static final String MECHANIC_BONUS_NOT_FOUND = "No se encontró el producto a bonificar";

	public static final String MECHANIC_TYPE_BONUS = "B";
	public static final String MECHANIC_TYPE_BONUS_TEXT = "Bonificación";
	public static final String MECHANIC_TYPE_SOLES = "S";
	public static final String MECHANIC_TYPE_SOLES_TEXT = "Soles";

	public static final String MECHANIC_MODALITY_PROVIDER = "P";
	public static final String MECHANIC_MODALITY_PROVIDER_TEXT = "Proveedor";
	public static final String MECHANIC_MODALITY_ARTICLE = "A";
	public static final String MECHANIC_MODALITY_ARTICLE_TEXT = "Artículo";

	public static final String MECHANIC_UNIT_UNITY = "U";
	public static final String MECHANIC_UNIT_UNITY_TEXT = "Unidades";
	public static final String MECHANIC_UNIT_SOLES = "S";
	public static final String MECHANIC_UNIT_SOLES_TEXT = "Soles";

	public static final String MECHANIC_STATUS_CREATED = "C";
	public static final String MECHANIC_STATUS_CREATED_TEXT = "Creada";
	public static final String MECHANIC_STATUS_DELETED = "D";
	public static final String MECHANIC_STATUS_DELETED_TEXT = "Eliminada";

	public static final String MECHANIC_INCLUDED_YES = "I";
	public static final String MECHANIC_INCLUDED_YES_TEXT = "Incluye";
	public static final String MECHANIC_INCLUDED_NO = "E";
	public static final String MECHANIC_INCLUDED_NO_TEXT = "Excluye";

	public static final String MECHANIC_TYPE_ARTICLE = "A";
	public static final String MECHANIC_TYPE_ARTICLE_TEXT = "Articulo";
	public static final String MECHANIC_TYPE_PROVIDER = "P";
	public static final String MECHANIC_TYPE_PROVIDER_TEXT = "Proveedor";

	public static final String EMITTER_PROVIDER = "P";
	public static final String EMITTER_PROVIDER_TEXT = "Proveedor";

	public static final String EMITTER_ECONOMYSA = "E";
	public static final String EMITTER_ECONOMYSA_TEXT = "Economysa";

	public static final String NOT_BLANK_EMAIL = "El campo Email es obligatorio";
	public static final String INVALID_SIZE_EMAIL = "El tamaño debe estar comprendido entre 1 y 50 caracteres";
	public static final String INVALID_EMAIL = "El formato del campo Email es inválido";

	public static final String NOT_BLANK_PASSWORD = "El campo Password es obligatorio";
	public static final String INVALID_SIZE_PASSWORD = "El tamaño debe estar comprendido entre 1 y 256 caracteres";

	public static final String NOT_BLANK_ROLE = "El campo Role es obligatorio";
	public static final String INVALID_SIZE_ROLE = "El tamaño debe estar comprendido entre 1 y 10 caracteres";

	public static final String NOT_BLANK_NAME = "El campo Name es obligatorio";
	public static final String INVALID_SIZE_NAME = "El tamanño debe estar comprendido entre 1 y 100 caracteres";

	public static final String NOT_BLANK_LAST_NAME = "El campo LastName es obligatorio";
	public static final String INVALID_SIZE_LAST_NAME = "El tamanño debe estar comprendido entre 1 y 100 caracteres";

	public static final String INVALID_SIZE_PHONE = "El tamaño debe estar comprendido entre 9 y 9 caracteres";
}
