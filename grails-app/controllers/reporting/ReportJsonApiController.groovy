package reporting

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper
import org.codehaus.groovy.runtime.InvokerHelper

class ReportJsonApiController {

    def reportService

    static responseFormats = ['json']
    static allowedMethods = [update: "PUT", newrec: "POST", saveList: "POST"]

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def index() {
        respond Report.list()
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def show(Report reportInstance) {
        respond reportInstance
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def saveList() {

        String jsonObject = request.getJSON()
        // get JSON data from request body
        def jsonList = new JsonSlurper().parseText(jsonObject)
        for (jsonObj in jsonList) {
            try {
                def report = new Report(jsonObj)
                report.save(flush: true) // save JSON directly to grails domain
                render report as JSON // render JSON object
            }
            catch (Exception e) {
                e.printStackTrace()
                render "Error saving category : " + e
            }
        }
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def newrec() {
        String jsonObject = request.JSON
        def rep = new Report(JSON.parse(jsonObject))
        rep.save(flush: true) // save JSON directly to grails domain
        render rep as JSON
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def update() {
        String jsonObject = request.JSON
        def report = new Report(JSON.parse(jsonObject))
        def rep = Report.list().find { it.id == request.getJSON().id }
        InvokerHelper.setProperties(rep, report.getProperties())
        rep.save(flush: true) // save JSON directly to grails domain
        render rep as JSON
    }
}