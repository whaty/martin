# martin-cloud-config
系统配置中心，提供两种存储方案，一种git，一种本地存储

启动martin-cloud-eureka → martin-cloud-config

访问：

http://localhost:9501/foot/dev

成功返回：

```text
{
	"name": "foot",
	"profiles": ["dev"],
	"label": null,
	"version": null,
	"state": null,
	"propertySources": [{
		"name": "classpath:config/application-dev.yml",
		"source": {
			"foot": "foot-dev4"
		}
	}, {
		"name": "classpath:config/application.yml",
		"source": {
			"spring.profiles.active": "dev",
			"foot": "foot"
		}
	}]
}
```

修改application-dev.yml中的foot值为foot-dev5

访问：

http://localhost:9501/actuator/refresh

再次访问：

http://localhost:9501/foot/dev

成功返回：

```text
{
	"name": "foot",
	"profiles": ["dev"],
	"label": null,
	"version": null,
	"state": null,
	"propertySources": [{
		"name": "classpath:config/application-dev.yml",
		"source": {
			"foot": "foot-dev5"
		}
	}, {
		"name": "classpath:config/application.yml",
		"source": {
			"spring.profiles.active": "dev",
			"foot": "foot"
		}
	}]
}
```