package uk.co.thomasc.steamkit.steam3.handlers.steamuser.callbacks;

import lombok.Getter;

import uk.co.thomasc.steamkit.base.generated.SteammessagesClientserver.CMsgClientAccountInfo;

import uk.co.thomasc.steamkit.base.generated.steamlanguage.EAccountFlags;
import uk.co.thomasc.steamkit.steam3.steamclient.callbackmgr.CallbackMsg;

/**
 * This callback is recieved when account information is recieved from the network.
 * This generally happens after logon.
 */
public final class AccountInfoCallback extends CallbackMsg {
	/**
	 * Gets the last recorded persona name used by this account.
	 */
	@Getter private String personaName;
	
	/**
	 * Gets the country this account is connected from.
	 */
	@Getter private String country;

	/**
	 * Gets the salt used for the password.
	 */
	@Getter private byte[] passwordSalt;

	/**
	 * Gets the SHA-1 disgest of the password.
	 */
	@Getter private byte[] passwordSHADisgest;

	/**
	 * Gets the count of SteamGuard authenticated computers.
	 */
	@Getter private int countAuthedComputers;

	/**
	 * Gets a value indicating whether this account is locked with IPT.
	 */
	@Getter private boolean lockedWithIPT;

	/**
	 * Gets the account flags for this account.
	 */
	@Getter private EAccountFlags accountFlags;

	/**
	 * Gets the facebook ID of this account if it is linked with facebook.
	 */
	@Getter private long facebookID;

	/**
	 * Gets the facebook name if this account is linked with facebook.
	 */
	@Getter private String facebookName;

	public AccountInfoCallback(CMsgClientAccountInfo msg) {
		personaName = msg.getPersonaName();
		country = msg.getIpCountry();

		passwordSalt = msg.getSaltPassword().toByteArray();
		passwordSHADisgest = msg.getShaDigestPassword().toByteArray();

		countAuthedComputers = msg.getCountAuthedComputers();
		lockedWithIPT = msg.getLockedWithIpt();

		accountFlags = EAccountFlags.f(msg.getAccountFlags());

		facebookID = msg.getFacebookId();
		facebookName = msg.getFacebookName();
	}
}