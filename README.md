### Load example dashboards, Load index templates, Collect Elasticsearch monitoring logs 

All of the information in this readme references the Elasticsearch 8.4.* documentation
https://www.elastic.co/guide/en/elasticsearch/reference/current/configuring-metricbeat.html

#### Configure Metricbeat to write to a specific output by setting options in the Outputs section of the metricbeat.yml file.
- Settings for enabled modules in the modules.d directory take precedence over module settings in the Metricbeat configuration file

#### Use Metricbeat modules to specify the Metricbeat configuration.
- Single cluster, Metricbeat scope: Node
- metricbeat.yml 
- modules.d/elasticsearch.yml 
- modules.d/kibana.yml

### Configure settings 
#### for each Metricbeat:
  - metricbeat.output 
  #### for each module enabled: 
    - host.path(s)
    - metricsets
    - username
    - password

#### if the connection is successful to:
output.elasticsearch.hosts: ["https://my-deployment-158070.es.us-west-1.aws.found.io:443"]
- load default index templates that control the behavior of your data streams and backing indices.
  
setup.kibana.host: ["https://my-deployment-158070.kb.us-west-1.aws.found.io:9243"]
- if an index pattern matches the metricbeat index (metricbeat-*)
- load example dashboards contained in metricbeat-8.4.2-windows-x86_64/*/dashboards to your Kibana instance
  

### Use Metricbeat modules to specify the Metricbeat configuration to collect Elasticsearch and Kibana monitoring logs

#### verify settings and fields 
- modules.d/kibana is of type DISABLED FILE and modules.d/kibana.xpack is of type "Yaml Source File"
- modules.d/elasticsearch is of type DISABLED FILE and modules.d/elastichsearch.xpack is of type "Yaml Source File"- roles for metricbeat_monitor and metricbeat_publisher 

- the collection of monitoring data is enabled using _cluster/settings returns "xpack.monitoring.collection.enabled": "true"

- the index templates that are used to configure the indices that store the monitoring data collected from a cluster.
- index templates using /_template/<index-template> custom_monitoring returns "index_patterns": [".monitoring-beats-7-*", ".monitoring-es-7-*", ".monitoring-kibana-7-*", ".monitoring-logstash-7-*"]

- role privleges using /_security/roles/<name> metricbeat_monitor and metricbeat_publish returns "create_doc", "create_index" on indices : monitoring-*
- user roles using /_security/user/<username> metricbeat_monitor_all returns roles [metricbeat_monitor, metricbeat_publisher, monitor] 

### Configure settings 
#### for each Metricbeat:
  - metricbeat.output 
  #### for each module enabled: 
    - host.path(s)
    - metricsets
    - username
    - password

 
#### if the connection is successful to:
elasticsearch.xpack.elasticsearch.hosts: ["https://my-deployment-158070.es.us-west-1.aws.found.io:443"]
- https://www.elastic.co/guide/en/beats/metricbeat/8.4/elasticsearch-output.html
- modify the elasticsearch output setting from default node 
- modify metricsets [ccr, cluster_stats, enrich, index, index_recovery, index_summary, ml_job, node, node_stats, pending_tasks, shard]
- submit REST requests from java using service url: https://552e1fdcded8402295b5ff0c5afcc412.us-west-1.aws.found.io
- test CLI using curl: curl -H "Authorization: ApiKey $ES_API_KEY" https://api.elastic-cloud.com/api/v1/deployments/<deployment id>


kibana.xpack.kibana.hosts: ["https://my-deployment-158070.kb.us-west-1.aws.found.io:9243"] 
- modify metricsets [ cluster_actions, cluster_rules, node_actions, node_rules, settings, stats, status]

Default dashboard for GET/_cat/indices/.monitoring-es-7-2022.09.29
![monitoring_logs_indices](https://user-images.githubusercontent.com/54422342/193157962-a43a9eb2-8f48-4971-bb88-749e88319d0c.jpg)


dashboard for GET .monitoring-kibana-7-2022.09.29![monitoring_logs_kibana](https://user-images.githubusercontent.com/54422342/193158217-c45e6231-6873-4a37-b046-711ded9646d4.jpg)


