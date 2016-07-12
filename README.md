# tl;dr

dockerでjenkinsを立ち上げた時点でgoogle login pluginが有効になった状態にするやつ。

## settings

please set your clientId, clientSecret, domain and user permission.

custom.groovy

~~~groovy
// google login settings
def clientId = "YOUR_GOOGLE_APP_CLIENT_ID"
def clientSecret = "YOUR_GOOGLE_APP_SECRET"
def domain = "google.com"

def googleRealm = new GoogleOAuth2SecurityRealm(clientId, clientSecret, domain)
instance.setSecurityRealm(googleRealm)
instance.save()

// Permission settings
def strategy = new GlobalMatrixAuthorizationStrategy()
// strategy.add(Jenkins.ADMINISTER, "hoge")
strategy.add(Jenkins.ADMINISTER, "sho20100@gmail.com") 
instance.setAuthorizationStrategy(strategy)
instance.save()
~~~

# run

~~~sh
$ docker build -t jenkins2 .
$ docker run -p 8080:8080 -p 50001:50001 --env JENKINS_SLAVE_AGENT_PORT=50001 jenkins2 
~~~
