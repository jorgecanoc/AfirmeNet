package com.afirme.afirmenet.model.transferencia;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;

/**
 * Clase base para realizar cualquier tipo de transaccion en el core bancario de
 * afirme, cada transaccion debera extender de esta clase a una clase concreta.
 * 
 * Las transacciones soportardas son las siguientes:
 * <ul>
 * <li>SPEI</li>
 * <li>TEFO/PIB/TEF</li>
 * <li>TERCEROS</li>
 * <li>PROPIAS</li>
 * <li>SWIFT</li>
 * </ul>
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
public class TransferenciaBase extends ComprobanteBase {
	private String contractId = "";
	private String debitAccount = "";
	private String creditAccount = "";
	private String currency = "";
	private String bankReceiving = "";
	private String plazaReceiving = "";
	private String beneficiaryName = "";
	private String emailBeneficiary = "";
	private String description = "";
	private String narrative = "";
	private String programmingDate="";
	private String programmingDay = "";
	private String programmingMonth = "";
	private String programmingYear = "";
	private String programmingHour = "";
	private String programmingMinute = "";
	private String validationHour = "";
	private String validationMinute = "";
	private String transactionCode = "";
	private String referenceNumber = "";
	private String serviceNumber = "";
	private BigDecimal commision = BigDecimal.ZERO;
	private BigDecimal taxCommision = BigDecimal.ZERO;
	private BigDecimal iva = BigDecimal.ZERO;
	private String operatorUser = "";
	private String validatorUser = "";
	private String authorizationUser = "";
	private String operationDate = "";
	private String validationDate = "";
	private String authorizationDate = "";
	private String operationState = "";
	private int approbationNumber;
	private String flag = "";
	private String account = "";
	private String bankFrm = "";
	private int counter;
	private String userReference = "";
	private String rfc = "";

	private BigDecimal amount = BigDecimal.ZERO;
	private String userId = "";
	private String accountNumber = "";
	private String accountType = "";
	private String state = "";
	private String type = "";
	private String accountOwner = "";
	private String nickName = "";
	private String bankName = "";
	private String bankCode = "";
	private String email = "";

	private String validationDay = "";
	private String validationMonth = "";
	private String validationYear = "";
	private Cuenta origen;
	private Cuenta destino;

	private String cveTasaPref = ""; // Clave para autorizacion de cambio de
										// moneda preferencial

	private List<Cuenta> cuentas;
	private List<Cuenta> cuentasPropias;
	private TipoTransferencia tipoTransferencia;
	
	private boolean esFavoritas;
	private boolean agregarFavoritas;	

	private int serviceType;
	private int interType;
	
	private TipoServicio tipoServicio;	

	public TransferenciaBase() {
		super();
	}

	public TransferenciaBase(String contractId, String debitAccount,
			String creditAccount, String currency, String bankReceiving,
			String plazaReceiving, String beneficiaryName,
			String emailBeneficiary, String description, String narrative,
			String programmingDay, String programmingMonth,
			String programmingYear, String programmingHour,
			String programmingMinute, String validationHour,
			String validationMinute, String transactionCode,
			String referenceNumber, String serviceNumber, BigDecimal commision,
			BigDecimal taxCommision, BigDecimal iva, String operatorUser,
			String validatorUser, String authorizationUser,
			String operationDate, String validationDate,
			String authorizationDate, String operationState,
			int approbationNumber, String flag, String account, String bankFrm,
			int counter, String userReference, String rfc, BigDecimal amount,
			String userId, String accountNumber, String accountType,
			String state, String type, String accountOwner, String nickName,
			String bankName, String bankCode, String email,
			String validationDay, String validationMonth,
			String validationYear, Map<CodigoExcepcion, String> errores) {
		super();
		this.contractId = contractId;
		this.debitAccount = debitAccount;
		this.creditAccount = creditAccount;
		this.currency = currency;
		this.bankReceiving = bankReceiving;
		this.plazaReceiving = plazaReceiving;
		this.beneficiaryName = beneficiaryName;
		this.emailBeneficiary = emailBeneficiary;
		this.description = description;
		this.narrative = narrative;
		this.programmingDay = programmingDay;
		this.programmingMonth = programmingMonth;
		this.programmingYear = programmingYear;
		this.programmingHour = programmingHour;
		this.programmingMinute = programmingMinute;
		this.validationHour = validationHour;
		this.validationMinute = validationMinute;
		this.transactionCode = transactionCode;
		this.referenceNumber = referenceNumber;
		this.serviceNumber = serviceNumber;
		this.commision = commision;
		this.taxCommision = taxCommision;
		this.iva = iva;
		this.operatorUser = operatorUser;
		this.validatorUser = validatorUser;
		this.authorizationUser = authorizationUser;
		this.operationDate = operationDate;
		this.validationDate = validationDate;
		this.authorizationDate = authorizationDate;
		this.operationState = operationState;
		this.approbationNumber = approbationNumber;
		this.flag = flag;
		this.account = account;
		this.bankFrm = bankFrm;
		this.counter = counter;
		this.userReference = userReference;
		this.rfc = rfc;
		this.amount = amount;
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.state = state;
		this.type = type;
		this.accountOwner = accountOwner;
		this.nickName = nickName;
		this.bankName = bankName;
		this.bankCode = bankCode;
		this.email = email;
		this.validationDay = validationDay;
		this.validationMonth = validationMonth;
		this.validationYear = validationYear;
		this.errores = errores;
	}

	private Map<CodigoExcepcion, String> errores;

	/**
	 * @return the contractId
	 */
	public String getContractId() {
		return contractId;
	}

	/**
	 * @param contractId
	 *            the contractId to set
	 */
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the debitAccount
	 */
	public String getDebitAccount() {
		return debitAccount;
	}

	/**
	 * @param debitAccount
	 *            the debitAccount to set
	 */
	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	/**
	 * @return the creditAccount
	 */
	public String getCreditAccount() {
		return creditAccount;
	}

	/**
	 * @param creditAccount
	 *            the creditAccount to set
	 */
	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the bankReceiving
	 */
	public String getBankReceiving() {
		return bankReceiving;
	}

	/**
	 * @param bankReceiving
	 *            the bankReceiving to set
	 */
	public void setBankReceiving(String bankReceiving) {
		this.bankReceiving = bankReceiving;
	}

	/**
	 * @return the plazaReceiving
	 */
	public String getPlazaReceiving() {
		return plazaReceiving;
	}

	/**
	 * @param plazaReceiving
	 *            the plazaReceiving to set
	 */
	public void setPlazaReceiving(String plazaReceiving) {
		this.plazaReceiving = plazaReceiving;
	}

	/**
	 * @return the beneficiaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	/**
	 * @param beneficiaryName
	 *            the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	/**
	 * @return the emailBeneficiary
	 */
	public String getEmailBeneficiary() {
		return emailBeneficiary;
	}

	/**
	 * @param emailBeneficiary
	 *            the emailBeneficiary to set
	 */
	public void setEmailBeneficiary(String emailBeneficiary) {
		this.emailBeneficiary = emailBeneficiary;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the narrative
	 */
	public String getNarrative() {
		return narrative;
	}

	/**
	 * @param narrative
	 *            the narrative to set
	 */
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	/**
	 * @return the programmingDay
	 */
	public String getProgrammingDay() {
		return programmingDay;
	}

	/**
	 * @param programmingDay
	 *            the programmingDay to set
	 */
	public void setProgrammingDay(String programmingDay) {
		this.programmingDay = programmingDay;
	}

	/**
	 * @return the programmingMonth
	 */
	public String getProgrammingMonth() {
		return programmingMonth;
	}

	/**
	 * @param programmingMonth
	 *            the programmingMonth to set
	 */
	public void setProgrammingMonth(String programmingMonth) {
		this.programmingMonth = programmingMonth;
	}

	/**
	 * @return the programmingYear
	 */
	public String getProgrammingYear() {
		return programmingYear;
	}

	/**
	 * @param programmingYear
	 *            the programmingYear to set
	 */
	public void setProgrammingYear(String programmingYear) {
		this.programmingYear = programmingYear;
	}

	/**
	 * @return the programmingHour
	 */
	public String getProgrammingHour() {
		return programmingHour;
	}

	/**
	 * @param programmingHour
	 *            the programmingHour to set
	 */
	public void setProgrammingHour(String programmingHour) {
		this.programmingHour = programmingHour;
	}

	/**
	 * @return the programmingMinute
	 */
	public String getProgrammingMinute() {
		return programmingMinute;
	}

	/**
	 * @param programmingMinute
	 *            the programmingMinute to set
	 */
	public void setProgrammingMinute(String programmingMinute) {
		this.programmingMinute = programmingMinute;
	}

	/**
	 * @return the validationHour
	 */
	public String getValidationHour() {
		return validationHour;
	}

	/**
	 * @param validationHour
	 *            the validationHour to set
	 */
	public void setValidationHour(String validationHour) {
		this.validationHour = validationHour;
	}

	/**
	 * @return the validationMinute
	 */
	public String getValidationMinute() {
		return validationMinute;
	}

	/**
	 * @param validationMinute
	 *            the validationMinute to set
	 */
	public void setValidationMinute(String validationMinute) {
		this.validationMinute = validationMinute;
	}

	/**
	 * @return the transactionCode
	 */
	public String getTransactionCode() {
		return transactionCode;
	}

	/**
	 * @param transactionCode
	 *            the transactionCode to set
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	/**
	 * @return the referenceNumber
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * @param referenceNumber
	 *            the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	/**
	 * @return the serviceNumber
	 */
	public String getServiceNumber() {
		return serviceNumber;
	}

	/**
	 * @param serviceNumber
	 *            the serviceNumber to set
	 */
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	/**
	 * @return the commision
	 */
	public BigDecimal getCommision() {
		return commision;
	}

	/**
	 * @param commision
	 *            the commision to set
	 */
	public void setCommision(BigDecimal commision) {
		this.commision = commision;
	}

	/**
	 * @return the taxCommision
	 */
	public BigDecimal getTaxCommision() {
		return taxCommision;
	}

	/**
	 * @param taxCommision
	 *            the taxCommision to set
	 */
	public void setTaxCommision(BigDecimal taxCommision) {
		this.taxCommision = taxCommision;
	}

	/**
	 * @return the iva
	 */
	public BigDecimal getIva() {
		return iva;
	}

	/**
	 * @param iva
	 *            the iva to set
	 */
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	/**
	 * @return the operatorUser
	 */
	public String getOperatorUser() {
		return operatorUser;
	}

	/**
	 * @param operatorUser
	 *            the operatorUser to set
	 */
	public void setOperatorUser(String operatorUser) {
		this.operatorUser = operatorUser;
	}

	/**
	 * @return the validatorUser
	 */
	public String getValidatorUser() {
		return validatorUser;
	}

	/**
	 * @param validatorUser
	 *            the validatorUser to set
	 */
	public void setValidatorUser(String validatorUser) {
		this.validatorUser = validatorUser;
	}

	/**
	 * @return the authorizationUser
	 */
	public String getAuthorizationUser() {
		return authorizationUser;
	}

	/**
	 * @param authorizationUser
	 *            the authorizationUser to set
	 */
	public void setAuthorizationUser(String authorizationUser) {
		this.authorizationUser = authorizationUser;
	}

	/**
	 * @return the operationDate
	 */
	public String getOperationDate() {
		return operationDate;
	}

	/**
	 * @param operationDate
	 *            the operationDate to set
	 */
	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	/**
	 * @return the validationDate
	 */
	public String getValidationDate() {
		return validationDate;
	}

	/**
	 * @param validationDate
	 *            the validationDate to set
	 */
	public void setValidationDate(String validationDate) {
		this.validationDate = validationDate;
	}

	/**
	 * @return the authorizationDate
	 */
	public String getAuthorizationDate() {
		return authorizationDate;
	}

	/**
	 * @param authorizationDate
	 *            the authorizationDate to set
	 */
	public void setAuthorizationDate(String authorizationDate) {
		this.authorizationDate = authorizationDate;
	}

	/**
	 * @return the operationState
	 */
	public String getOperationState() {
		return operationState;
	}

	/**
	 * @param operationState
	 *            the operationState to set
	 */
	public void setOperationState(String operationState) {
		this.operationState = operationState;
	}

	/**
	 * @return the approbationNumber
	 */
	public int getApprobationNumber() {
		return approbationNumber;
	}

	/**
	 * @param approbationNumber
	 *            the approbationNumber to set
	 */
	public void setApprobationNumber(int approbationNumber) {
		this.approbationNumber = approbationNumber;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the bankFrm
	 */
	public String getBankFrm() {
		return bankFrm;
	}

	/**
	 * @param bankFrm
	 *            the bankFrm to set
	 */
	public void setBankFrm(String bankFrm) {
		this.bankFrm = bankFrm;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter
	 *            the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @return the userReference
	 */
	public String getUserReference() {
		return userReference;
	}

	/**
	 * @param userReference
	 *            the userReference to set
	 */
	public void setUserReference(String userReference) {
		this.userReference = userReference;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the accountOwner
	 */
	public String getAccountOwner() {
		return accountOwner;
	}

	/**
	 * @param accountOwner
	 *            the accountOwner to set
	 */
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode
	 *            the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the validationDay
	 */
	public String getValidationDay() {
		return validationDay;
	}

	/**
	 * @param validationDay
	 *            the validationDay to set
	 */
	public void setValidationDay(String validationDay) {
		this.validationDay = validationDay;
	}

	/**
	 * @return the validationMonth
	 */
	public String getValidationMonth() {
		return validationMonth;
	}

	/**
	 * @param validationMonth
	 *            the validationMonth to set
	 */
	public void setValidationMonth(String validationMonth) {
		this.validationMonth = validationMonth;
	}

	/**
	 * @return the validationYear
	 */
	public String getValidationYear() {
		return validationYear;
	}

	/**
	 * @param validationYear
	 *            the validationYear to set
	 */
	public void setValidationYear(String validationYear) {
		this.validationYear = validationYear;
	}

	/**
	 * @return the origen
	 */
	public Cuenta getOrigen() {
		return origen;
	}

	/**
	 * @param origen
	 *            the origen to set
	 */
	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	/**
	 * @return the destino
	 */
	public Cuenta getDestino() {
		return destino;
	}

	/**
	 * @param destino
	 *            the destino to set
	 */
	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the errores
	 */
	public Map<CodigoExcepcion, String> getErrores() {
		return errores;
	}

	/**
	 * @param errores
	 *            the errores to set
	 */
	public void setErrores(Map<CodigoExcepcion, String> errores) {
		this.errores = errores;
	}

	/**
	 * @return the cuentas
	 */
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	/**
	 * @param cuentas
	 *            the cuentas to set
	 */
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	/**
	 * @return the cuentasPropias
	 */
	public List<Cuenta> getCuentasPropias() {
		return cuentasPropias;
	}

	/**
	 * @param cuentasPropias
	 *            the cuentasPropias to set
	 */
	public void setCuentasPropias(List<Cuenta> cuentasPropias) {
		this.cuentasPropias = cuentasPropias;
	}

	/**
	 * @return the tipoTransferencia
	 */
	public TipoTransferencia getTipoTransferencia() {
		return tipoTransferencia;
	}

	/**
	 * @param tipoTransferencia
	 *            the tipoTransferencia to set
	 */
	public void setTipoTransferencia(TipoTransferencia tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}

	/**
	 * @return el cveTasaPref
	 */
	public String getCveTasaPref() {
		return cveTasaPref;
	}

	/**
	 * @param cveTasaPref
	 *            el cveTasaPref a establecer
	 */
	public void setCveTasaPref(String cveTasaPref) {
		this.cveTasaPref = cveTasaPref;
	}

	/**
	 * @return the programmingDate
	 */
	public String getProgrammingDate() {
		return programmingDate;
	}

	/**
	 * @param programmingDate the programmingDate to set
	 */
	public void setProgrammingDate(String programmingDate) {
		this.programmingDate = programmingDate;
	}

	/**
	 * @return the esFavoritas
	 */
	public boolean isEsFavoritas() {
		return esFavoritas;
	}

	/**
	 * @param esFavoritas the esFavoritas to set
	 */
	public void setEsFavoritas(boolean esFavoritas) {
		this.esFavoritas = esFavoritas;
	}

	/**
	 * @return the agregarFavoritas
	 */
	public boolean isAgregarFavoritas() {
		return agregarFavoritas;
	}

	/**
	 * @param agregarFavoritas the agregarFavoritas to set
	 */
	public void setAgregarFavoritas(boolean agregarFavoritas) {
		this.agregarFavoritas = agregarFavoritas;
	}

	/**
	 * @return el serviceType
	 */
	public int getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType el serviceType a establecer
	 */
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return el interType
	 */
	public int getInterType() {
		return interType;
	}

	/**
	 * @param interType el interType a establecer
	 */
	public void setInterType(int interType) {
		this.interType = interType;
	}

	/**
	 * @return the tipoServicio
	 */
	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio the tipoServicio to set
	 */
	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	

}
