import jenkins.*
import hudson.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import hudson.plugins.sshslaves.*;
import hudson.model.*
import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.googlelogin.GoogleOAuth2SecurityRealm

def instance = Jenkins.getInstance()

// 通常のユーザを作る場合
// def hudsonRealm = new HudsonPrivateSecurityRealm(false)
// hudsonRealm.createAccount("hoge","your_password")
// instance.setSecurityRealm(hudsonRealm)
// instance.save()

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

