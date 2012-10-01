package uk.co.thomasc.steamkit.steam3.handlers.steamworkshop.callbacks;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import uk.co.thomasc.steamkit.base.generated.SteammessagesClientserver.CMsgClientUCMEnumerateUserSubscribedFilesResponse;
import uk.co.thomasc.steamkit.base.generated.SteammessagesClientserver.CMsgClientUCMEnumerateUserSubscribedFilesResponse.PublishedFileId;

import uk.co.thomasc.steamkit.base.generated.steamlanguage.EResult;
import uk.co.thomasc.steamkit.steam3.handlers.steamworkshop.SteamWorkshop;
import uk.co.thomasc.steamkit.steam3.handlers.steamworkshop.types.EnumerationUserDetails;
import uk.co.thomasc.steamkit.steam3.handlers.steamworkshop.types.FileSubscribed;
import uk.co.thomasc.steamkit.steam3.steamclient.callbackmgr.CallbackMsg;

/**
 * This callback is received in response to calling {@link SteamWorkshop#enumerateUserSubscribedFiles(EnumerationUserDetails)}.
 */
public final class UserSubscribedFilesCallback extends CallbackMsg {
	/**
	 * Gets the result.
	 */
	@Getter private EResult result;

	/**
	 * Gets the list of enumerated files.
	 */
	@Getter private List<FileSubscribed> files = new ArrayList<FileSubscribed>();

	/**
	 * Gets the count of total results.
	 */
	@Getter private int totalResults;

	public UserSubscribedFilesCallback(CMsgClientUCMEnumerateUserSubscribedFilesResponse msg) {
		this.result = EResult.f(msg.getEresult());

		for (PublishedFileId f : msg.getSubscribedFilesList()) {
			files.add(new FileSubscribed(f));
		}

		this.totalResults = msg.getTotalResults();
	}
}