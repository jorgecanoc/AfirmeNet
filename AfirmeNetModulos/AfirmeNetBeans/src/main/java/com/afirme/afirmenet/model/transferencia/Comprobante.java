package com.afirme.afirmenet.model.transferencia;

public class Comprobante extends TransferenciaBase implements
		ComprobanteTransferencia {

	public Comprobante() {
		super();
	}

	public Comprobante(TransferenciaBase base) {
		setContractId(base.getContractId());
		setDebitAccount(base.getDebitAccount());
		setCreditAccount(base.getCreditAccount());
		setCurrency(base.getCurrency());
		setBankReceiving(base.getBankReceiving());
		setPlazaReceiving(base.getPlazaReceiving());
		setBeneficiaryName(base.getBeneficiaryName());
		setEmailBeneficiary(base.getEmailBeneficiary());
		setDescription(base.getDescription());
		setNarrative(base.getNarrative());
		setProgrammingDay(base.getProgrammingDay());
		setProgrammingMonth(base.getProgrammingMonth());
		setProgrammingYear(base.getProgrammingYear());
		setProgrammingHour(base.getProgrammingHour());
		setProgrammingMinute(base.getProgrammingMinute());
		setValidationHour(base.getValidationHour());
		setValidationMinute(base.getValidationMinute());
		setTransactionCode(base.getTransactionCode());
		setReferenceNumber(base.getReferenceNumber());
		setServiceNumber(base.getServiceNumber());
		setCommision(base.getCommision());
		setTaxCommision(base.getTaxCommision());
		setIva(base.getIva());
		setOperatorUser(base.getOperatorUser());
		setValidatorUser(base.getValidatorUser());
		setAuthorizationUser(base.getAuthorizationUser());
		setOperationDate(base.getOperationDate());
		setValidationDate(base.getValidationDate());
		setAuthorizationDate(base.getAuthorizationDate());
		setOperationState(base.getOperationState());
		setApprobationNumber(base.getApprobationNumber());
		setFlag(base.getFlag());
		setAccount(base.getAccount());
		setBankFrm(base.getBankFrm());
		setCounter(base.getCounter());
		setUserReference(base.getUserReference());
		setRfc(base.getRfc());
		setAmount(base.getAmount());
		setUserId(base.getUserId());
		setAccountNumber(base.getAccountNumber());
		setAccountType(base.getAccountType());
		setState(base.getState());
		setAccountOwner(base.getAccountOwner());
		setNickName(base.getNickName());
		setBankName(base.getBankName());
		setBankCode(base.getBankCode());
		setEmail(base.getEmail());
		setValidationDay(base.getValidationDay());
		setValidationMonth(base.getValidationMonth());
		setValidationYear(base.getValidationYear());
		setErrores(base.getErrores());
		setTipoTransferencia(base.getTipoTransferencia());
		setOrigen(base.getOrigen());
		setDestino(base.getDestino());
		setAgregarFavoritas(base.isAgregarFavoritas());
		setTipoServicio(base.getTipoServicio());
		setServiceType(base.getServiceType());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comprobante [afirmeNetReference=");
		builder.append(getAfirmeNetReference());
		builder.append("\n");
		builder.append(", trackingCode=");
		builder.append(getTrackingCode());
		builder.append("\n");
		builder.append(", speiReference=");
		builder.append(getSpeiReference());
		builder.append("\n");
		builder.append(", getContractId()=");
		builder.append(getContractId());
		builder.append("\n");
		builder.append(", getDebitAccount()=");
		builder.append(getDebitAccount());
		builder.append("\n");
		builder.append(", getCreditAccount()=");
		builder.append(getCreditAccount());
		builder.append("\n");
		builder.append(", getCurrency()=");
		builder.append(getCurrency());
		builder.append("\n");
		builder.append(", getBankReceiving()=");
		builder.append(getBankReceiving());
		builder.append("\n");
		builder.append(", getPlazaReceiving()=");
		builder.append(getPlazaReceiving());
		builder.append("\n");
		builder.append(", getBeneficiaryName()=");
		builder.append(getBeneficiaryName());
		builder.append("\n");
		builder.append(", getEmailBeneficiary()=");
		builder.append(getEmailBeneficiary());
		builder.append("\n");
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append("\n");
		builder.append(", getNarrative()=");
		builder.append(getNarrative());
		builder.append("\n");
		builder.append(", getProgrammingDay()=");
		builder.append(getProgrammingDay());
		builder.append("\n");
		builder.append(", getProgrammingMonth()=");
		builder.append(getProgrammingMonth());
		builder.append("\n");
		builder.append(", getProgrammingYear()=");
		builder.append(getProgrammingYear());
		builder.append("\n");
		builder.append(", getProgrammingHour()=");
		builder.append(getProgrammingHour());
		builder.append("\n");
		builder.append(", getProgrammingMinute()=");
		builder.append(getProgrammingMinute());
		builder.append("\n");
		builder.append(", getValidationHour()=");
		builder.append(getValidationHour());
		builder.append("\n");
		builder.append(", getValidationMinute()=");
		builder.append(getValidationMinute());
		builder.append("\n");
		builder.append(", getTransactionCode()=");
		builder.append(getTransactionCode());
		builder.append("\n");
		builder.append(", getReferenceNumber()=");
		builder.append(getReferenceNumber());
		builder.append("\n");
		builder.append(", getServiceNumber()=");
		builder.append(getServiceNumber());
		builder.append("\n");
		builder.append(", getCommision()=");
		builder.append(getCommision());
		builder.append("\n");
		builder.append(", getTaxCommision()=");
		builder.append(getTaxCommision());
		builder.append("\n");
		builder.append(", getIva()=");
		builder.append(getIva());
		builder.append("\n");
		builder.append(", getOperatorUser()=");
		builder.append(getOperatorUser());
		builder.append("\n");
		builder.append(", getValidatorUser()=");
		builder.append(getValidatorUser());
		builder.append("\n");
		builder.append(", getAuthorizationUser()=");
		builder.append(getAuthorizationUser());
		builder.append("\n");
		builder.append(", getOperationDate()=");
		builder.append(getOperationDate());
		builder.append("\n");
		builder.append(", getValidationDate()=");
		builder.append(getValidationDate());
		builder.append("\n");
		builder.append(", getAuthorizationDate()=");
		builder.append(getAuthorizationDate());
		builder.append("\n");
		builder.append(", getOperationState()=");
		builder.append(getOperationState());
		builder.append("\n");
		builder.append(", getApprobationNumber()=");
		builder.append(getApprobationNumber());
		builder.append("\n");
		builder.append(", getFlag()=");
		builder.append(getFlag());
		builder.append("\n");
		builder.append(", getAccount()=");
		builder.append(getAccount());
		builder.append("\n");
		builder.append(", getBankFrm()=");
		builder.append(getBankFrm());
		builder.append("\n");
		builder.append(", getCounter()=");
		builder.append(getCounter());
		builder.append("\n");
		builder.append(", getUserReference()=");
		builder.append(getUserReference());
		builder.append("\n");
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append("\n");
		builder.append(", getUserId()=");
		builder.append(getUserId());
		builder.append("\n");
		builder.append(", getAccountNumber()=");
		builder.append(getAccountNumber());
		builder.append("\n");
		builder.append(", getAccountType()=");
		builder.append(getAccountType());
		builder.append("\n");
		builder.append(", getState()=");
		builder.append(getState());
		builder.append("\n");
		builder.append(", getType()=");
		builder.append(getType());
		builder.append("\n");
		builder.append(", getAccountOwner()=");
		builder.append(getAccountOwner());
		builder.append("\n");
		builder.append(", getNickName()=");
		builder.append(getNickName());
		builder.append("\n");
		builder.append(", getBankName()=");
		builder.append(getBankName());
		builder.append("\n");
		builder.append(", getBankCode()=");
		builder.append(getBankCode());
		builder.append("\n");
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append("\n");
		builder.append(", getValidationDay()=");
		builder.append(getValidationDay());
		builder.append("\n");
		builder.append(", getValidationMonth()=");
		builder.append(getValidationMonth());
		builder.append("\n");
		builder.append(", getValidationYear()=");
		builder.append(getValidationYear());
		builder.append("\n");
		builder.append(", getOrigen()=");
		builder.append(getOrigen());
		builder.append("\n");
		builder.append(", getDestino()=");
		builder.append(getDestino());
		builder.append("\n");
		builder.append(", getRfc()=");
		builder.append(getRfc());
		builder.append("\n");
		builder.append(", getErrores()=");
		builder.append(getErrores());
		builder.append("\n");
		builder.append(", getCuentas()=");
		builder.append(getCuentas());
		builder.append("\n");
		builder.append(", getCuentasPropias()=");
		builder.append(getCuentasPropias());
		builder.append("\n");
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append("\n");
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("\n");
		builder.append("]");
		return builder.toString();
	}
}
