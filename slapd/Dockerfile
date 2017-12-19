FROM alpine
MAINTAINER Karl Werner <info@zap.de.com>

# Expose LDAP ports
EXPOSE 389 636

# Install OpenLDAP server
RUN apk update && apk add openldap openldap-clients ldapvi openldap-back-mdb

# Add launch script
ADD start /usr/sbin/start-slapd
RUN chmod +x /usr/sbin/start-slapd

RUN mkdir /var/run/openldap/
run chown -R ldap:ldap /var/run/openldap/

# Add slapd configuration
ADD slapd.conf /etc/openldap/slapd.conf

# Add schema
ADD lumpy.schema /etc/openldap/schema/lumpy.schema

# Verify configuration
RUN slaptest -u

# Run OpenLDAP
ENTRYPOINT ["/usr/sbin/start-slapd"]
