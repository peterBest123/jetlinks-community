package com.troila.datacoll.network.manager.entity;

import com.troila.datacoll.network.DefaultNetworkType;
import com.troila.datacoll.network.NetworkProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hswebframework.ezorm.rdb.mapping.annotation.ColumnType;
import org.hswebframework.ezorm.rdb.mapping.annotation.DefaultValue;
import org.hswebframework.ezorm.rdb.mapping.annotation.EnumCodec;
import org.hswebframework.ezorm.rdb.mapping.annotation.JsonCodec;
import org.hswebframework.web.api.crud.entity.GenericEntity;
import com.troila.datacoll.network.manager.enums.NetworkConfigState;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.JDBCType;
import java.util.Map;

@Getter
@Setter
@Table(name = "network_config")
public class NetworkConfigEntity extends GenericEntity<String> {

    @Column
    @NotNull(message = "名称不能为空")
    @Schema(description = "名称")
    private String name;

    @Column
    @Schema(description = "说明")
    private String description;

    @Column(nullable = false)
    @EnumCodec
    @ColumnType(javaType = String.class)
    @NotNull(message = "类型不能为空")
    @Schema(description = "类型")
    private DefaultNetworkType type;

    @Column(nullable = false)
    @EnumCodec
    @ColumnType(javaType = String.class)
    @DefaultValue("disabled")
    @Schema(description = "状态")
    private NetworkConfigState state;

    @Column
    @JsonCodec
    @ColumnType(jdbcType = JDBCType.CLOB, javaType = String.class)
    @Schema(description = "配置(根据类型不同而不同)")
    private Map<String, Object> configuration;

    public NetworkProperties toNetworkProperties() {
        NetworkProperties properties = new NetworkProperties();
        properties.setConfigurations(configuration);
        properties.setEnabled(state == NetworkConfigState.enabled);
        properties.setId(getId());
        properties.setName(name);

        return properties;
    }

}
