package metricbeat;

import org.junit.jupiter.api.*;

// Test the Elasticsearch output that sends events directly to Elasticsearch using the Elasticsearch HTTP API.
public class ElasticsearchOutputTest {
    //  Elasticsearch output settings to be tested:
    // - authentication
    // - index and index selector rules
    // - pipeline and pipeline selector rules
    // - index lifecycle management

    // Test default index name that events are written to when using daily indices. "metricbeat-%{[agent.version]}-
    void writeEventToIndexTest() {
    }

    // Test the array of index selector rules. Each rule specifies the index to use for events that match the rule
    void writeEventToIndexIfContainsSpecifiedString() {

    }

    // Test the format string value that specifies the ingest pipeline to write events to.
    @Test
    void writeEventToPipelineTest() {
    }

    // Test arrays of pipeline selector rules. Each rule specifies the ingest pipeline to use for events that match the rule.
    @Test
    void sendEventsToPipelineWhenMessageContainsTest() {
    }

    @Test
    void setPipelineFromMappedPipelineFormatString() {

    }
}