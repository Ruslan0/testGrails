package reporting

import grails.converters.JSON
import groovy.json.JsonSlurper
import org.codehaus.groovy.runtime.InvokerHelper

class ReportJsonApiController {

    def reportService

    static responseFormats = ['json']
    static allowedMethods = [update: "PUT", create: "POST", saveList: "POST"]

    def index() {
        respond Report.list()
    }

    def show(Report reportInstance) {
        respond reportInstance
    }

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

    def create() {
        String jsonObject = request.JSON
        def rep = new Report(JSON.parse(jsonObject))
        reportService.save(rep)
        render rep as JSON
    }

    def update() {
        String jsonObject = request.JSON
        def report = new Report(JSON.parse(jsonObject))
        def rep = Report.list().find { it.id == request.getJSON().id }
        InvokerHelper.setProperties(rep, report.getProperties())
        reportService.save(rep)
        render rep as JSON
    }
}