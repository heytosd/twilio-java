/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v1;

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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Service extends Resource {
    private static final long serialVersionUID = 209287578457944L;

    /**
     * Create a ServiceFetcher to execute fetch.
     * 
     * @param pathSid The unique string that identifies the resource
     * @return ServiceFetcher capable of executing the fetch
     */
    public static ServiceFetcher fetcher(final String pathSid) {
        return new ServiceFetcher(pathSid);
    }

    /**
     * Create a ServiceDeleter to execute delete.
     * 
     * @param pathSid The unique string that identifies the resource
     * @return ServiceDeleter capable of executing the delete
     */
    public static ServiceDeleter deleter(final String pathSid) {
        return new ServiceDeleter(pathSid);
    }

    /**
     * Create a ServiceCreator to execute create.
     * 
     * @param friendlyName A string to describe the resource
     * @return ServiceCreator capable of executing the create
     */
    public static ServiceCreator creator(final String friendlyName) {
        return new ServiceCreator(friendlyName);
    }

    /**
     * Create a ServiceReader to execute read.
     * 
     * @return ServiceReader capable of executing the read
     */
    public static ServiceReader reader() {
        return new ServiceReader();
    }

    /**
     * Create a ServiceUpdater to execute update.
     * 
     * @param pathSid The unique string that identifies the resource
     * @return ServiceUpdater capable of executing the update
     */
    public static ServiceUpdater updater(final String pathSid) {
        return new ServiceUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a Service object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Service object represented by the provided JSON
     */
    public static Service fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Service object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Service object represented by the provided JSON
     */
    public static Service fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String defaultServiceRoleSid;
    private final String defaultChannelRoleSid;
    private final String defaultChannelCreatorRoleSid;
    private final Boolean readStatusEnabled;
    private final Boolean reachabilityEnabled;
    private final Integer typingIndicatorTimeout;
    private final Integer consumptionReportInterval;
    private final Map<String, Object> limits;
    private final Map<String, Object> webhooks;
    private final String preWebhookUrl;
    private final String postWebhookUrl;
    private final String webhookMethod;
    private final List<String> webhookFilters;
    private final Map<String, Object> notifications;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Service(@JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("friendly_name")
                    final String friendlyName, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("default_service_role_sid")
                    final String defaultServiceRoleSid, 
                    @JsonProperty("default_channel_role_sid")
                    final String defaultChannelRoleSid, 
                    @JsonProperty("default_channel_creator_role_sid")
                    final String defaultChannelCreatorRoleSid, 
                    @JsonProperty("read_status_enabled")
                    final Boolean readStatusEnabled, 
                    @JsonProperty("reachability_enabled")
                    final Boolean reachabilityEnabled, 
                    @JsonProperty("typing_indicator_timeout")
                    final Integer typingIndicatorTimeout, 
                    @JsonProperty("consumption_report_interval")
                    final Integer consumptionReportInterval, 
                    @JsonProperty("limits")
                    final Map<String, Object> limits, 
                    @JsonProperty("webhooks")
                    final Map<String, Object> webhooks, 
                    @JsonProperty("pre_webhook_url")
                    final String preWebhookUrl, 
                    @JsonProperty("post_webhook_url")
                    final String postWebhookUrl, 
                    @JsonProperty("webhook_method")
                    final String webhookMethod, 
                    @JsonProperty("webhook_filters")
                    final List<String> webhookFilters, 
                    @JsonProperty("notifications")
                    final Map<String, Object> notifications, 
                    @JsonProperty("url")
                    final URI url, 
                    @JsonProperty("links")
                    final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.defaultServiceRoleSid = defaultServiceRoleSid;
        this.defaultChannelRoleSid = defaultChannelRoleSid;
        this.defaultChannelCreatorRoleSid = defaultChannelCreatorRoleSid;
        this.readStatusEnabled = readStatusEnabled;
        this.reachabilityEnabled = reachabilityEnabled;
        this.typingIndicatorTimeout = typingIndicatorTimeout;
        this.consumptionReportInterval = consumptionReportInterval;
        this.limits = limits;
        this.webhooks = webhooks;
        this.preWebhookUrl = preWebhookUrl;
        this.postWebhookUrl = postWebhookUrl;
        this.webhookMethod = webhookMethod;
        this.webhookFilters = webhookFilters;
        this.notifications = notifications;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The The unique string that identifies the resource.
     * 
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
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
     * Returns The The string that you assigned to describe the resource.
     * 
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the resource was created.
     * 
     * @return The RFC 2822 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the resource was last
     * updated.
     * 
     * @return The RFC 2822 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The service role assigned to users when they are added to the
     * service.
     * 
     * @return The service role assigned to users when they are added to the service
     */
    public final String getDefaultServiceRoleSid() {
        return this.defaultServiceRoleSid;
    }

    /**
     * Returns The The channel role assigned to users when they are added to a
     * channel.
     * 
     * @return The channel role assigned to users when they are added to a channel
     */
    public final String getDefaultChannelRoleSid() {
        return this.defaultChannelRoleSid;
    }

    /**
     * Returns The The channel role assigned to a channel creator when they join a
     * new channel.
     * 
     * @return The channel role assigned to a channel creator when they join a new
     *         channel
     */
    public final String getDefaultChannelCreatorRoleSid() {
        return this.defaultChannelCreatorRoleSid;
    }

    /**
     * Returns The Whether the Message Consumption Horizon feature is enabled.
     * 
     * @return Whether the Message Consumption Horizon feature is enabled
     */
    public final Boolean getReadStatusEnabled() {
        return this.readStatusEnabled;
    }

    /**
     * Returns The Whether the Reachability Indicator feature is enabled for this
     * Service instance.
     * 
     * @return Whether the Reachability Indicator feature is enabled for this
     *         Service instance
     */
    public final Boolean getReachabilityEnabled() {
        return this.reachabilityEnabled;
    }

    /**
     * Returns The How long in seconds to wait before assuming the user is no longer
     * typing.
     * 
     * @return How long in seconds to wait before assuming the user is no longer
     *         typing
     */
    public final Integer getTypingIndicatorTimeout() {
        return this.typingIndicatorTimeout;
    }

    /**
     * Returns The DEPRECATED.
     * 
     * @return DEPRECATED
     */
    public final Integer getConsumptionReportInterval() {
        return this.consumptionReportInterval;
    }

    /**
     * Returns The An object that describes the limits of the service instance.
     * 
     * @return An object that describes the limits of the service instance
     */
    public final Map<String, Object> getLimits() {
        return this.limits;
    }

    /**
     * Returns The An object that contains information about the webhooks configured
     * for this service.
     * 
     * @return An object that contains information about the webhooks configured
     *         for this service
     */
    public final Map<String, Object> getWebhooks() {
        return this.webhooks;
    }

    /**
     * Returns The The webhook URL for pre-event webhooks.
     * 
     * @return The webhook URL for pre-event webhooks
     */
    public final String getPreWebhookUrl() {
        return this.preWebhookUrl;
    }

    /**
     * Returns The The URL for post-event webhooks.
     * 
     * @return The URL for post-event webhooks
     */
    public final String getPostWebhookUrl() {
        return this.postWebhookUrl;
    }

    /**
     * Returns The The HTTP method  to use for both PRE and POST webhooks.
     * 
     * @return The HTTP method  to use for both PRE and POST webhooks
     */
    public final String getWebhookMethod() {
        return this.webhookMethod;
    }

    /**
     * Returns The The list of WebHook events that are enabled for this Service
     * instance.
     * 
     * @return The list of WebHook events that are enabled for this Service instance
     */
    public final List<String> getWebhookFilters() {
        return this.webhookFilters;
    }

    /**
     * Returns The The notification configuration for the Service instance.
     * 
     * @return The notification configuration for the Service instance
     */
    public final Map<String, Object> getNotifications() {
        return this.notifications;
    }

    /**
     * Returns The The absolute URL of the Service resource.
     * 
     * @return The absolute URL of the Service resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The absolute URLs of the Service's Channels, Roles, and Users.
     * 
     * @return The absolute URLs of the Service's Channels, Roles, and Users
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

        Service other = (Service) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(defaultServiceRoleSid, other.defaultServiceRoleSid) && 
               Objects.equals(defaultChannelRoleSid, other.defaultChannelRoleSid) && 
               Objects.equals(defaultChannelCreatorRoleSid, other.defaultChannelCreatorRoleSid) && 
               Objects.equals(readStatusEnabled, other.readStatusEnabled) && 
               Objects.equals(reachabilityEnabled, other.reachabilityEnabled) && 
               Objects.equals(typingIndicatorTimeout, other.typingIndicatorTimeout) && 
               Objects.equals(consumptionReportInterval, other.consumptionReportInterval) && 
               Objects.equals(limits, other.limits) && 
               Objects.equals(webhooks, other.webhooks) && 
               Objects.equals(preWebhookUrl, other.preWebhookUrl) && 
               Objects.equals(postWebhookUrl, other.postWebhookUrl) && 
               Objects.equals(webhookMethod, other.webhookMethod) && 
               Objects.equals(webhookFilters, other.webhookFilters) && 
               Objects.equals(notifications, other.notifications) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            dateCreated,
                            dateUpdated,
                            defaultServiceRoleSid,
                            defaultChannelRoleSid,
                            defaultChannelCreatorRoleSid,
                            readStatusEnabled,
                            reachabilityEnabled,
                            typingIndicatorTimeout,
                            consumptionReportInterval,
                            limits,
                            webhooks,
                            preWebhookUrl,
                            postWebhookUrl,
                            webhookMethod,
                            webhookFilters,
                            notifications,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("friendlyName", friendlyName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("defaultServiceRoleSid", defaultServiceRoleSid)
                          .add("defaultChannelRoleSid", defaultChannelRoleSid)
                          .add("defaultChannelCreatorRoleSid", defaultChannelCreatorRoleSid)
                          .add("readStatusEnabled", readStatusEnabled)
                          .add("reachabilityEnabled", reachabilityEnabled)
                          .add("typingIndicatorTimeout", typingIndicatorTimeout)
                          .add("consumptionReportInterval", consumptionReportInterval)
                          .add("limits", limits)
                          .add("webhooks", webhooks)
                          .add("preWebhookUrl", preWebhookUrl)
                          .add("postWebhookUrl", postWebhookUrl)
                          .add("webhookMethod", webhookMethod)
                          .add("webhookFilters", webhookFilters)
                          .add("notifications", notifications)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}