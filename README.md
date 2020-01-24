# asciidoc-converter

This is a Java Application to convert html used to convert an adoc file to html used for Wordpress. This 
is used to make the process easy for the .adoc Open Liberty blog to Wordpress HTML which is used to publish 
Open Liberty content on Red Hat website.

## Prerequisites

* Asciidoctor

## Steps:

.1. Retrive file you want to convert 
E.g: 2020-01-17-openshift-oauth-server-social-login-liberty-20001.adoc

.2. Run `asciidoctor <name of file>
eg `asciidoctor 2020-01-17-openshift-oauth-server-social-login-liberty-20001.adoc`

Output: `2020-01-17-openshift-oauth-server-social-login-liberty-20001.html"

.3. Locate file path or move the file to src folder

.4. run `java <filename.html>`
eg ` java 2020-01-17-openshift-oauth-server-social-login-liberty-20001.html`

Output: `rendered-<filename>`

Done!

This will have converted it ready for the Red Hat blog post, save the contents of the local copy and 
paste the HTML into wordpress




