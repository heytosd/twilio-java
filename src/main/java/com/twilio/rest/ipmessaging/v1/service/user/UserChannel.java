/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v1.service.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserChannel extends Resource {
    private static final long serialVersionUID = 254880238496884L;

    public enum ChannelStatus {
        JOINED("joined"),
        INVITED("invited"),
        NOT_PARTICIPATING("not_participating");

        private final String value;

        private ChannelStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ChannelStatus from a string.
         * @param value string value
         * @return generated ChannelStatus
         */
        @JsonCreator
        public static ChannelStatus forValue(final String value) {
            return Promoter.enumFromString(value, ChannelStatus.values());
        }
    }

    /**
     * Create a UserChannelReader to execute read.
     * 
     * @param pathServiceSid The SID of the Service to read the resources from
     * @param pathUserSid The SID of the User to fetch the User Channel resources
     *                    from
     * @return UserChannelReader capable of executing the read
     */
    public static UserChannelReader reader(final String pathServiceSid, 
                                           final String pathUserSid) {
        return new UserChannelReader(pathServiceSid, pathUserSid);
    }

    /**
     * Converts a JSON String into a UserChannel object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return UserChannel object represented by the provided JSON
     */
    public static UserChannel fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UserChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a UserChannel object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return UserChannel object represented by the provided JSON
     */
    public static UserChannel fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UserChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String serviceSid;
    private final String channelSid;
    private final String memberSid;
    private final UserChannel.ChannelStatus status;
    private final Integer lastConsumedMessageIndex;
    private final Integer unreadMessagesCount;
    private final Map<String, String> links;

    @JsonCreator
    private UserChannel(@JsonProperty("account_sid")
                        final String accountSid, 
                        @JsonProperty("service_sid")
                        final String serviceSid, 
                        @JsonProperty("channel_sid")
                        final String channelSid, 
                        @JsonProperty("member_sid")
                        final String memberSid, 
                        @JsonProperty("status")
                        final UserChannel.ChannelStatus status, 
                        @JsonProperty("last_consumed_message_index")
                        final Integer lastConsumedMessageIndex, 
                        @JsonProperty("unread_messages_count")
                        final Integer unreadMessagesCount, 
                        @JsonProperty("links")
                        final Map<String, String> links) {
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
        this.memberSid = memberSid;
        this.status = status;
        this.lastConsumedMessageIndex = lastConsumedMessageIndex;
        this.unreadMessagesCount = unreadMessagesCount;
        this.links = links;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     * 
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The SID of the Service that the resource is associated with.
     * 
     * @return The SID of the Service that the resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The SID of the Channel the resource belongs to.
     * 
     * @return The SID of the Channel the resource belongs to
     */
    public final String getChannelSid() {
        return this.channelSid;
    }

    /**
     * Returns The The SID of the User as a Member in the Channel.
     * 
     * @return The SID of the User as a Member in the Channel
     */
    public final String getMemberSid() {
        return this.memberSid;
    }

    /**
     * Returns The The status of the User on the Channel.
     * 
     * @return The status of the User on the Channel
     */
    public final UserChannel.ChannelStatus getStatus() {
        return this.status;
    }

    /**
     * Returns The The index of the last Message in the Channel the Member has read.
     * 
     * @return The index of the last Message in the Channel the Member has read
     */
    public final Integer getLastConsumedMessageIndex() {
        return this.lastConsumedMessageIndex;
    }

    /**
     * Returns The The number of unread Messages in the Channel for the User.
     * 
     * @return The number of unread Messages in the Channel for the User
     */
    public final Integer getUnreadMessagesCount() {
        return this.unreadMessagesCount;
    }

    /**
     * Returns The Absolute URLs to access the Members, Messages , Invites and, if
     * it exists, the last Message for the Channel.
     * 
     * @return Absolute URLs to access the Members, Messages , Invites and, if it
     *         exists, the last Message for the Channel
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserChannel other = (UserChannel) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(channelSid, other.channelSid) && 
               Objects.equals(memberSid, other.memberSid) && 
               Objects.equals(status, other.status) && 
               Objects.equals(lastConsumedMessageIndex, other.lastConsumedMessageIndex) && 
               Objects.equals(unreadMessagesCount, other.unreadMessagesCount) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            serviceSid,
                            channelSid,
                            memberSid,
                            status,
                            lastConsumedMessageIndex,
                            unreadMessagesCount,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("channelSid", channelSid)
                          .add("memberSid", memberSid)
                          .add("status", status)
                          .add("lastConsumedMessageIndex", lastConsumedMessageIndex)
                          .add("unreadMessagesCount", unreadMessagesCount)
                          .add("links", links)
                          .toString();
    }
}