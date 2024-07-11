package com.alinesno.infra.base.storage.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 *
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("document_info")
public class DocumentInfoEntity extends InfraBaseEntity {
	/**
	 * 文档标题
	 */
	@ColumnType(length = 255)
	@ColumnComment("文档标题")
	@TableField("title")
	private String title;

	/**
	 * 文档格式('Word', 'Office', 'Excel', 'PPT', '其他')
	 */
	@ColumnType(length = 6)
	@ColumnComment("文档格式('Word', 'Office', 'Excel', 'PPT', '其他')")
	@TableField("format")
	private String format;

	/**
	 * 文件地址
	 */
	@ColumnType(length = 256)
	@ColumnComment("文件URL")
	@TableField("url")
	private String url ;

	/**
	 * 查看次数
	 */
	@ColumnType(MySqlTypeConstant.INT)
	@ColumnComment("查看次数")
	@TableField("view_count")
	private int viewCount;

	/**
	 * 打印次数
	 */
	@ColumnType(MySqlTypeConstant.INT)
	@ColumnComment("打印次数")
	@TableField("print_count")
	private int printCount;

	/**
	 * 是否公开
	 */
	@ColumnType(MySqlTypeConstant.INT)
	@ColumnComment("是否公开")
	@TableField("has_public")
	private int hasPublic;


}
