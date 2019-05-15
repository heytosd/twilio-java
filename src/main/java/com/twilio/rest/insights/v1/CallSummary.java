/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.insights.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallSummary extends Resource {
    private static final long serialVersionUID = 261922425029875L;

    public enum CallType {
        CARRIER("carrier"),
        SIP("sip"),
        TRUNKING("trunking"),
        CLIENT("client");

        private final String value;

        private CallType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a CallType from a string.
         * @param value string value
         * @return generated CallType
         */
        @JsonCreator
        public static CallType forValue(final String value) {
            return Promoter.enumFromString(value, CallType.values());
        }
    }

    public enum CallState {
        RINGING("ringing"),
        COMPLETED("completed"),
        BUSY("busy"),
        FAIL("fail"),
        NOANSWER("noanswer"),
        CANCELED("canceled"),
        ANSWERED("answered"),
        UNDIALED("undialed");

        private final String value;

        private CallState(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a CallState from a string.
         * @param value string value
         * @return generated CallState
         */
        @JsonCreator
        public static CallState forValue(final String value) {
            return Promoter.enumFromString(value, CallState.values());
        }
    }

    public enum ProcessingState {
        COMPLETE("complete"),
        PARTIAL("partial");

        private final String value;

        private ProcessingState(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ProcessingState from a string.
         * @param value string value
         * @return generated ProcessingState
         */
        @JsonCreator
        public static ProcessingState forValue(final String value) {
            return Promoter.enumFromString(value, ProcessingState.values());
        }
    }

    public enum Direction {
        INBOUND("inbound"),
        OUTBOUND_API("outbound_api"),
        OUTBOUND_DIAL("outbound_dial"),
        TRUNKING_ORIGINATING("trunking_originating"),
        TRUNKING_TERMINATING("trunking_terminating");

        private final String value;

        private Direction(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Direction from a string.
         * @param value string value
         * @return generated Direction
         */
        @JsonCreator
        public static Direction forValue(final String value) {
            return Promoter.enumFromString(value, Direction.values());
        }
    }

    public enum DisconnectedBy {
        CALLEE("callee"),
        CALLER("caller"),
        UNKNOWN("unknown");

        private final String value;

        private DisconnectedBy(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a DisconnectedBy from a string.
         * @param value string value
         * @return generated DisconnectedBy
         */
        @JsonCreator
        public static DisconnectedBy forValue(final String value) {
            return Promoter.enumFromString(value, DisconnectedBy.values());
        }
    }

    /**
     * Create a CallSummaryFetcher to execute fetch.
     * 
     * @param pathCallSid The call_sid
     * @return CallSummaryFetcher capable of executing the fetch
     */
    public static CallSummaryFetcher fetcher(final String pathCallSid) {
        return new CallSummaryFetcher(pathCallSid);
    }

    /**
     * Converts a JSON String into a CallSummary object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return CallSummary object represented by the provided JSON
     */
    public static CallSummary fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CallSummary.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a CallSummary object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return CallSummary object represented by the provided JSON
     */
    public static CallSummary fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CallSummary.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String callSid;
    private final CallSummary.CallType callType;
    private final CallSummary.CallState callState;
    private final CallSummary.ProcessingState processingState;
    private final CallSummary.Direction direction;
    private final CallSummary.DisconnectedBy disconnectedBy;
    private final DateTime startTime;
    private final DateTime endTime;
    private final Integer duration;
    private final Integer connectDuration;
    private final Map<String, Object> from;
    private final Map<String, Object> to;
    private final Map<String, Object> carrierEdge;
    private final Map<String, Object> clientEdge;
    private final Map<String, Object> sdkEdge;
    private final Map<String, Object> sipEdge;
    private final List<String> tags;
    private final URI url;

    @JsonCreator
    private CallSummary(@JsonProperty("account_sid")
                        final String accountSid, 
                        @JsonProperty("call_sid")
                        final String callSid, 
                        @JsonProperty("call_type")
                        final CallSummary.CallType callType, 
                        @JsonProperty("call_state")
                        final CallSummary.CallState callState, 
                        @JsonProperty("processing_state")
                        final CallSummary.ProcessingState processingState, 
                        @JsonProperty("direction")
                        final CallSummary.Direction direction, 
                        @JsonProperty("disconnected_by")
                        final CallSummary.DisconnectedBy disconnectedBy, 
                        @JsonProperty("start_time")
                        final String startTime, 
                        @JsonProperty("end_time")
                        final String endTime, 
                        @JsonProperty("duration")
                        final Integer duration, 
                        @JsonProperty("connect_duration")
                        final Integer connectDuration, 
                        @JsonProperty("from")
                        final Map<String, Object> from, 
                        @JsonProperty("to")
                        final Map<String, Object> to, 
                        @JsonProperty("carrier_edge")
                        final Map<String, Object> carrierEdge, 
                        @JsonProperty("client_edge")
                        final Map<String, Object> clientEdge, 
                        @JsonProperty("sdk_edge")
                        final Map<String, Object> sdkEdge, 
                        @JsonProperty("sip_edge")
                        final Map<String, Object> sipEdge, 
                        @JsonProperty("tags")
                        final List<String> tags, 
                        @JsonProperty("url")
                        final URI url) {
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.callType = callType;
        this.callState = callState;
        this.processingState = processingState;
        this.direction = direction;
        this.disconnectedBy = disconnectedBy;
        this.startTime = DateConverter.iso8601DateTimeFromString(startTime);
        this.endTime = DateConverter.iso8601DateTimeFromString(endTime);
        this.duration = duration;
        this.connectDuration = connectDuration;
        this.from = from;
        this.to = to;
        this.carrierEdge = carrierEdge;
        this.clientEdge = clientEdge;
        this.sdkEdge = sdkEdge;
        this.sipEdge = sipEdge;
        this.tags = tags;
        this.url = url;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The call_sid.
     * 
     * @return The call_sid
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * Returns The The call_type.
     * 
     * @return The call_type
     */
    public final CallSummary.CallType getCallType() {
        return this.callType;
    }

    /**
     * Returns The The call_state.
     * 
     * @return The call_state
     */
    public final CallSummary.CallState getCallState() {
        return this.callState;
    }

    /**
     * Returns The The processing_state.
     * 
     * @return The processing_state
     */
    public final CallSummary.ProcessingState getProcessingState() {
        return this.processingState;
    }

    /**
     * Returns The The direction.
     * 
     * @return The direction
     */
    public final CallSummary.Direction getDirection() {
        return this.direction;
    }

    /**
     * Returns The The disconnected_by.
     * 
     * @return The disconnected_by
     */
    public final CallSummary.DisconnectedBy getDisconnectedBy() {
        return this.disconnectedBy;
    }

    /**
     * Returns The The start_time.
     * 
     * @return The start_time
     */
    public final DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns The The end_time.
     * 
     * @return The end_time
     */
    public final DateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns The The duration.
     * 
     * @return The duration
     */
    public final Integer getDuration() {
        return this.duration;
    }

    /**
     * Returns The The connect_duration.
     * 
     * @return The connect_duration
     */
    public final Integer getConnectDuration() {
        return this.connectDuration;
    }

    /**
     * Returns The The from.
     * 
     * @return The from
     */
    public final Map<String, Object> getFrom() {
        return this.from;
    }

    /**
     * Returns The The to.
     * 
     * @return The to
     */
    public final Map<String, Object> getTo() {
        return this.to;
    }

    /**
     * Returns The The carrier_edge.
     * 
     * @return The carrier_edge
     */
    public final Map<String, Object> getCarrierEdge() {
        return this.carrierEdge;
    }

    /**
     * Returns The The client_edge.
     * 
     * @return The client_edge
     */
    public final Map<String, Object> getClientEdge() {
        return this.clientEdge;
    }

    /**
     * Returns The The sdk_edge.
     * 
     * @return The sdk_edge
     */
    public final Map<String, Object> getSdkEdge() {
        return this.sdkEdge;
    }

    /**
     * Returns The The sip_edge.
     * 
     * @return The sip_edge
     */
    public final Map<String, Object> getSipEdge() {
        return this.sipEdge;
    }

    /**
     * Returns The The tags.
     * 
     * @return The tags
     */
    public final List<String> getTags() {
        return this.tags;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CallSummary other = (CallSummary) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(callSid, other.callSid) && 
               Objects.equals(callType, other.callType) && 
               Objects.equals(callState, other.callState) && 
               Objects.equals(processingState, other.processingState) && 
               Objects.equals(direction, other.direction) && 
               Objects.equals(disconnectedBy, other.disconnectedBy) && 
               Objects.equals(startTime, other.startTime) && 
               Objects.equals(endTime, other.endTime) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(connectDuration, other.connectDuration) && 
               Objects.equals(from, other.from) && 
               Objects.equals(to, other.to) && 
               Objects.equals(carrierEdge, other.carrierEdge) && 
               Objects.equals(clientEdge, other.clientEdge) && 
               Objects.equals(sdkEdge, other.sdkEdge) && 
               Objects.equals(sipEdge, other.sipEdge) && 
               Objects.equals(tags, other.tags) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            callSid,
                            callType,
                            callState,
                            processingState,
                            direction,
                            disconnectedBy,
                            startTime,
                            endTime,
                            duration,
                            connectDuration,
                            from,
                            to,
                            carrierEdge,
                            clientEdge,
                            sdkEdge,
                            sipEdge,
                            tags,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("callSid", callSid)
                          .add("callType", callType)
                          .add("callState", callState)
                          .add("processingState", processingState)
                          .add("direction", direction)
                          .add("disconnectedBy", disconnectedBy)
                          .add("startTime", startTime)
                          .add("endTime", endTime)
                          .add("duration", duration)
                          .add("connectDuration", connectDuration)
                          .add("from", from)
                          .add("to", to)
                          .add("carrierEdge", carrierEdge)
                          .add("clientEdge", clientEdge)
                          .add("sdkEdge", sdkEdge)
                          .add("sipEdge", sipEdge)
                          .add("tags", tags)
                          .add("url", url)
                          .toString();
    }
}