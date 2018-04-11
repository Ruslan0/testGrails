package reporting

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper

class ReportJsonApiController {

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
        try {
            def rep = new Report(JSON.parse(jsonObject))
            rep.save(flush: true) // save JSON directly to grails domain
            render rep as JSON

        }
        catch (Exception e) {
            e.printStackTrace()
            render "Error saving category : " + e
        }
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def update() {
        def rep = Report.list().find { it.id == request.getJSON().id }
        rep.save(flush: true) // save JSON directly to grails domain
        render rep as JSON
    }
}