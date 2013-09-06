package de.scheduler.util;

import org.apache.log4j.Logger;

/**
 * The Class SpecialtySelector is used to choose which specialty to display to
 * the user.
 */
public class SpecialtySelector {

	protected static Logger logger = Logger.getLogger(SpecialtySelector.class);

	/**
	 * Gets the specialty id by trying to parse the passed cookie. Note, if the
	 * cookie doesn't contain a valid number the specialty id from the defaultSpecialty will be returned.
	 *
	 * @param cookieValue the cookie value
	 * @param defaultSpecialtyID the default specialty
	 * @return the specialty id
	 */
	public static int getSpecialtyId(String cookieValue, Integer defaultSpecialtyID) {
		int specialtyId = defaultSpecialtyID.intValue();
		if (cookieValue != null && !cookieValue.equals("")) {
			try {
				int parsedSpecialtyId = Integer.parseInt(cookieValue);
				specialtyId = parsedSpecialtyId;
			} catch (NumberFormatException e) {
				logger.debug("Exception occured while reading cookie value, loading default view. "
						+ e.getLocalizedMessage());
			}
		}
		return specialtyId;
	}

}
