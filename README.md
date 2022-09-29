### Metricbeat is a data shipper installed as an agent on your server to send operational metric data to Elasticsearch
https://www.elastic.co/guide/en/beats/metricbeat/8.4/metricbeat-overview.html

### Enable the modules that define the basic logic for collecting data from a specific service.

#### Enable and configure the Elasticsearch module
Load the index templates that control the behavior of your data streams and backing indces.
- A successfull connection to Elasticsearch will load the default templates.
- modules.d/elasticsearch.yml configuration
- hosts: ["https://my-deployment-158070.es.us-west-1.aws.found.io:443"]


#### Configure Metricbeat to write to a specific output by setting options in the Outputs section of the metricbeat.yml file.
- the output host path setting https://my-deployment-158070.es.us-west-1.aws.found.io:443
- the username and password credentials 

Enable and configure the Kibana module
setup host 
- Create an index pattern and load the packaged dashboard examples into your Kibana.

#### Collect Kibana monitoring data
- hosts: ["https://my-deployment-158070.kb.us-west-1.aws.found.io:9243"]
- create roles with privledes on monitoring-* indices to monitor, read and write using api path /_security/roles 
- create a user with roles: kibana_admin, ingest_admin, metricbeat_setup, metricbeat_monitor, metricbeat_writer using api path /_security/user

#### Collect Elasticsearch monitoring logs with Metricbeat 
- Enable modules.d/elasticsearch-xpack
- Enable modules.d/kibana-xpack

