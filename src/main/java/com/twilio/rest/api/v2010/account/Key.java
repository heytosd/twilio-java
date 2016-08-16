/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Key extends Resource {
    private static final long serialVersionUID = 96350302686036L;

    /**
     * Create a KeyFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return KeyFetcher capable of executing the fetch
     */
    public static KeyFetcher fetch(final String accountSid, 
                                   final String sid) {
        return new KeyFetcher(accountSid, sid);
    }

    /**
     * Create a KeyFetcher to execute fetch.
     * 
     * @param sid The sid
     * @return KeyFetcher capable of executing the fetch
     */
    public static KeyFetcher fetch(final String sid) {
        return new KeyFetcher(sid);
    }

    /**
     * Create a KeyUpdater to execute update.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return KeyUpdater capable of executing the update
     */
    public static KeyUpdater update(final String accountSid, 
                                    final String sid) {
        return new KeyUpdater(accountSid, sid);
    }

    /**
     * Create a KeyUpdater to execute update.
     * 
     * @param sid The sid
     * @return KeyUpdater capable of executing the update
     */
    public static KeyUpdater update(final String sid) {
        return new KeyUpdater(sid);
    }

    /**
     * Create a KeyDeleter to execute delete.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return KeyDeleter capable of executing the delete
     */
    public static KeyDeleter delete(final String accountSid, 
                                    final String sid) {
        return new KeyDeleter(accountSid, sid);
    }

    /**
     * Create a KeyDeleter to execute delete.
     * 
     * @param sid The sid
     * @return KeyDeleter capable of executing the delete
     */
    public static KeyDeleter delete(final String sid) {
        return new KeyDeleter(sid);
    }

    /**
     * Create a KeyReader to execute read.
     * 
     * @param accountSid The account_sid
     * @return KeyReader capable of executing the read
     */
    public static KeyReader read(final String accountSid) {
        return new KeyReader(accountSid);
    }

    /**
     * Create a KeyReader to execute read.
     * 
     * @return KeyReader capable of executing the read
     */
    public static KeyReader read() {
        return new KeyReader();
    }

    /**
     * Converts a JSON String into a Key object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Key object represented by the provided JSON
     */
    public static Key fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Key.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Key object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Key object represented by the provided JSON
     */
    public static Key fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Key.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String friendlyName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private Key(@JsonProperty("sid")
                final String sid, 
                @JsonProperty("friendly_name")
                final String friendlyName, 
                @JsonProperty("date_created")
                final String dateCreated, 
                @JsonProperty("date_updated")
                final String dateUpdated) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Key other = (Key) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            friendlyName,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("friendlyName", friendlyName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}