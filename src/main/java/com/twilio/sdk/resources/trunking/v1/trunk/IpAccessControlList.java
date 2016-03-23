package com.twilio.sdk.resources.trunking.v1.trunk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.creators.trunking.v1.trunk.IpAccessControlListCreator;
import com.twilio.sdk.deleters.trunking.v1.trunk.IpAccessControlListDeleter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.trunking.v1.trunk.IpAccessControlListFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.trunking.v1.trunk.IpAccessControlListReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpAccessControlList extends SidResource {
    private static final long serialVersionUID = 45032598628398L;

    /**
     * Create a IpAccessControlListFetcher to execute fetch.
     * 
     * @param trunkSid The trunk_sid
     * @param sid The sid
     * @return IpAccessControlListFetcher capable of executing the fetch
     */
    public static IpAccessControlListFetcher fetch(final String trunkSid, 
                                                   final String sid) {
        return new IpAccessControlListFetcher(trunkSid, sid);
    }

    /**
     * Create a IpAccessControlListDeleter to execute delete.
     * 
     * @param trunkSid The trunk_sid
     * @param sid The sid
     * @return IpAccessControlListDeleter capable of executing the delete
     */
    public static IpAccessControlListDeleter delete(final String trunkSid, 
                                                    final String sid) {
        return new IpAccessControlListDeleter(trunkSid, sid);
    }

    /**
     * Create a IpAccessControlListCreator to execute create.
     * 
     * @param trunkSid The trunk_sid
     * @param ipAccessControlListSid The ip_access_control_list_sid
     * @return IpAccessControlListCreator capable of executing the create
     */
    public static IpAccessControlListCreator create(final String trunkSid, 
                                                    final String ipAccessControlListSid) {
        return new IpAccessControlListCreator(trunkSid, ipAccessControlListSid);
    }

    /**
     * Create a IpAccessControlListReader to execute read.
     * 
     * @param trunkSid The trunk_sid
     * @return IpAccessControlListReader capable of executing the read
     */
    public static IpAccessControlListReader read(final String trunkSid) {
        return new IpAccessControlListReader(trunkSid);
    }

    /**
     * Converts a JSON String into a IpAccessControlList object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return IpAccessControlList object represented by the provided JSON
     */
    public static IpAccessControlList fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a IpAccessControlList object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return IpAccessControlList object represented by the provided JSON
     */
    public static IpAccessControlList fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String trunkSid;
    private final String friendlyName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private IpAccessControlList(@JsonProperty("account_sid")
                                final String accountSid, 
                                @JsonProperty("sid")
                                final String sid, 
                                @JsonProperty("trunk_sid")
                                final String trunkSid, 
                                @JsonProperty("friendly_name")
                                final String friendlyName, 
                                @JsonProperty("date_created")
                                final String dateCreated, 
                                @JsonProperty("date_updated")
                                final String dateUpdated, 
                                @JsonProperty("url")
                                final URI url) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.trunkSid = trunkSid;
        this.friendlyName = friendlyName;
        this.dateCreated = MarshalConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = MarshalConverter.iso8601DateTimeFromString(dateUpdated);
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
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The trunk_sid.
     * 
     * @return The trunk_sid
     */
    public final String getTrunkSid() {
        return this.trunkSid;
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
        
        IpAccessControlList other = (IpAccessControlList) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(trunkSid, other.trunkSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            sid,
                            trunkSid,
                            friendlyName,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("sid", sid)
                          .add("trunkSid", trunkSid)
                          .add("friendlyName", friendlyName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}