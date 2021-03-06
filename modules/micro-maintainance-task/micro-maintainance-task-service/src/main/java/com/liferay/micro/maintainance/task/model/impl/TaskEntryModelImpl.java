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

package com.liferay.micro.maintainance.task.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.model.TaskEntryModel;
import com.liferay.micro.maintainance.task.model.TaskEntrySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TaskEntry service. Represents a row in the &quot;Task_TaskEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TaskEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryImpl
 * @see TaskEntry
 * @see TaskEntryModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TaskEntryModelImpl extends BaseModelImpl<TaskEntry>
	implements TaskEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task entry model instance should use the {@link TaskEntry} interface instead.
	 */
	public static final String TABLE_NAME = "Task_TaskEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "taskEntryId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "taskEntryName", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("taskEntryName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Task_TaskEntry (uuid_ VARCHAR(75) null,taskEntryId LONG not null primary key,createDate DATE null,taskEntryName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Task_TaskEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY taskEntry.taskEntryName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Task_TaskEntry.taskEntryName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.micro.maintainance.task.model.TaskEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.micro.maintainance.task.model.TaskEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.micro.maintainance.task.model.TaskEntry"),
			true);
	public static final long TASKENTRYID_COLUMN_BITMASK = 1L;
	public static final long TASKENTRYNAME_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TaskEntry toModel(TaskEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TaskEntry model = new TaskEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setTaskEntryId(soapModel.getTaskEntryId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setTaskEntryName(soapModel.getTaskEntryName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TaskEntry> toModels(TaskEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TaskEntry> models = new ArrayList<TaskEntry>(soapModels.length);

		for (TaskEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.micro.maintainance.task.service.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.micro.maintainance.task.model.TaskEntry"));

	public TaskEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taskEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaskEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TaskEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TaskEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskEntryId", getTaskEntryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("taskEntryName", getTaskEntryName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskEntryId = (Long)attributes.get("taskEntryId");

		if (taskEntryId != null) {
			setTaskEntryId(taskEntryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String taskEntryName = (String)attributes.get("taskEntryName");

		if (taskEntryName != null) {
			setTaskEntryName(taskEntryName);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTaskEntryId() {
		return _taskEntryId;
	}

	@Override
	public void setTaskEntryId(long taskEntryId) {
		_columnBitmask |= TASKENTRYID_COLUMN_BITMASK;

		if (!_setOriginalTaskEntryId) {
			_setOriginalTaskEntryId = true;

			_originalTaskEntryId = _taskEntryId;
		}

		_taskEntryId = taskEntryId;
	}

	public long getOriginalTaskEntryId() {
		return _originalTaskEntryId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getTaskEntryName() {
		if (_taskEntryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _taskEntryName;
		}
	}

	@Override
	public void setTaskEntryName(String taskEntryName) {
		_columnBitmask = -1L;

		if (_originalTaskEntryName == null) {
			_originalTaskEntryName = _taskEntryName;
		}

		_taskEntryName = taskEntryName;
	}

	public String getOriginalTaskEntryName() {
		return GetterUtil.getString(_originalTaskEntryName);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TaskEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TaskEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TaskEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaskEntryImpl taskEntryImpl = new TaskEntryImpl();

		taskEntryImpl.setUuid(getUuid());
		taskEntryImpl.setTaskEntryId(getTaskEntryId());
		taskEntryImpl.setCreateDate(getCreateDate());
		taskEntryImpl.setTaskEntryName(getTaskEntryName());

		taskEntryImpl.resetOriginalValues();

		return taskEntryImpl;
	}

	@Override
	public int compareTo(TaskEntry taskEntry) {
		int value = 0;

		value = getTaskEntryName().compareTo(taskEntry.getTaskEntryName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskEntry)) {
			return false;
		}

		TaskEntry taskEntry = (TaskEntry)obj;

		long primaryKey = taskEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TaskEntryModelImpl taskEntryModelImpl = this;

		taskEntryModelImpl._originalUuid = taskEntryModelImpl._uuid;

		taskEntryModelImpl._originalTaskEntryId = taskEntryModelImpl._taskEntryId;

		taskEntryModelImpl._setOriginalTaskEntryId = false;

		taskEntryModelImpl._originalTaskEntryName = taskEntryModelImpl._taskEntryName;

		taskEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TaskEntry> toCacheModel() {
		TaskEntryCacheModel taskEntryCacheModel = new TaskEntryCacheModel();

		taskEntryCacheModel.uuid = getUuid();

		String uuid = taskEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			taskEntryCacheModel.uuid = null;
		}

		taskEntryCacheModel.taskEntryId = getTaskEntryId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			taskEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			taskEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		taskEntryCacheModel.taskEntryName = getTaskEntryName();

		String taskEntryName = taskEntryCacheModel.taskEntryName;

		if ((taskEntryName != null) && (taskEntryName.length() == 0)) {
			taskEntryCacheModel.taskEntryName = null;
		}

		return taskEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", taskEntryId=");
		sb.append(getTaskEntryId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", taskEntryName=");
		sb.append(getTaskEntryName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.micro.maintainance.task.model.TaskEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskEntryId</column-name><column-value><![CDATA[");
		sb.append(getTaskEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskEntryName</column-name><column-value><![CDATA[");
		sb.append(getTaskEntryName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TaskEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TaskEntry.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _taskEntryId;
	private long _originalTaskEntryId;
	private boolean _setOriginalTaskEntryId;
	private Date _createDate;
	private String _taskEntryName;
	private String _originalTaskEntryName;
	private long _columnBitmask;
	private TaskEntry _escapedModel;
}