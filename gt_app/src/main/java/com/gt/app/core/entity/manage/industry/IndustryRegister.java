package com.gt.app.core.entity.manage.industry;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 行业注册表
 * </p>
 *
 * @author psr
 * @since 2017-12-13
 */
@Data
@Accessors(chain = true)
@TableName("t_industry_register")
public class IndustryRegister extends Model<IndustryRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 行业code
     */
	private String industryCode;
    /**
     * 行业名称
     */
	private String industryName;
    /**
     * 行业状态（0：未开启，1：开启）
     */
	private Integer industryStatus;
    /**
     * 行业链接
     */
	private String industryUrl;
    /**
     * 创建时间
     */
	private Date createTime;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
