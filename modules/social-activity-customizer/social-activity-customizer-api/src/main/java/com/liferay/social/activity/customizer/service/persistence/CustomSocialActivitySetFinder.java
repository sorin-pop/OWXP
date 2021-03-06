/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.social.activity.customizer.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface CustomSocialActivitySetFinder {
	public int countByU_C(long userId, long classNameId);

	public int countByU_C_T(long userId, long classNameId, long[] types);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet> findByU_C(
		long userId, long classNameId, int begin, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet> findByU_C_T(
		long userId, long classNameId, long[] types, int begin, int end);
}