import geb.buildadapter.BuildAdapterFactory
import geb.driver.BrowserStackDriverFactory
import geb.driver.SauceLabsDriverFactory

testValue = true // used in a test in geb-core

String getForkIndex(int total) {
    String workerName = System.getProperty('org.gradle.test.worker')
    int workerNumber = workerName ? ((workerName =~ /[^\d]*([\d]+)/)[0][1]).toInteger() : 0
    (workerNumber % total).toString()
}

void setPortIndexProperty(String index) {
    System.setProperty('geb.port.index', index)
}

if (!BuildAdapterFactory.getBuildAdapter(this.class.classLoader).reportsDir) {
    reportsDir = "build/geb"
}

def sauceLabsBrowser = System.getProperty("geb.saucelabs.browser")
if (sauceLabsBrowser) {
    setPortIndexProperty(getForkIndex(5))
    driver = {
        def username = System.getenv("GEB_SAUCE_LABS_USER")
        assert username
        def accessKey = System.getenv("GEB_SAUCE_LABS_ACCESS_PASSWORD")
        assert accessKey
        def tunnelId = System.getProperty("geb.saucelabs.tunnelId")
        assert tunnelId
        new SauceLabsDriverFactory().create(sauceLabsBrowser, username, accessKey, ["tunnel-identifier": tunnelId])
    }
}

def browserStackBrowser = System.getProperty("geb.browserstack.browser")
if (browserStackBrowser) {
    setPortIndexProperty(getForkIndex(5))
    driver = {
        def username = System.getenv("GEB_BROWSERSTACK_USERNAME")
        assert username
        def accessKey = System.getenv("GEB_BROWSERSTACK_AUTHKEY")
        assert accessKey
        def tunnelId = System.getProperty("geb.browserstack.tunnelId")
        assert tunnelId
        new BrowserStackDriverFactory().create(browserStackBrowser, username, accessKey, ["browserstack.localIdentifier": tunnelId])
    }
}

def devDriver = System.getProperty("geb.dev.driver")
if (devDriver != "htmlunit") {
    driver = devDriver
}