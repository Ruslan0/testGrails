package reporting

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class ReportController {

    def reportService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def index(Integer max) {
        params.max = Math.min(max ?: 5, 100)
        respond reportService.list(params), model:[reportInstanceCount: reportService.countrRports()]
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def show(Report reportInstance) {
        respond reportInstance
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def create() {
        new Report(params)
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def save(Report reportInstance) {

        reportService.save(reportInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reportInstance.label', default: 'Report'), reportInstance.id])
                redirect reportInstance
            }
            '*' { respond reportInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def edit(Report reportInstance) {
        respond reportInstance
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def update(Report reportInstance) {

        reportService.save(reportInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Report.label', default: 'Report'), reportInstance.id])
                redirect reportInstance
            }
            '*'{ respond reportInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMINY', 'ROLE_COMMON'])
    def delete(Report reportInstance) {

        if (reportInstance == null) {
            notFound()
            return
        }

        reportService.delete(reportInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Report.label', default: 'Report'), reportInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportInstance.label', default: 'Report'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
