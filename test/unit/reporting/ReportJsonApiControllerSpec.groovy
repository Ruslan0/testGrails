package reporting

import grails.converters.JSON
import grails.test.mixin.TestFor
import reporting.Report
import reporting.ReportJsonApiController
import reporting.ReportService
import spock.lang.Specification


/**
 * Created by paluektau on 4/11/2018.
 */
@TestFor(ReportJsonApiController)
class ReportJsonApiControllerSpec extends Specification {

    void 'JSON payload is bound to the command object. If the report is saved, a 200 is returned'() {
        given:

        Long id = 244L
        String name = "Миша"
        String city = "Дубай"
        Date startDate = Date.parse("YYYY-MM-DD","2018-05-10")
        Date endDate = Date.parse("YYYY-MM-DD", "2018-05-17")
        String purpose = "Отдых"
        String notes = "Пляжный4"
        String user = "admin"

        controller.reportService = Stub(ReportService) {
//            save(_, _) >> new Report(name: name, grade: grade, id: id)
            save(_, _) >> new Report(
                    id: id,
                    city: city,
                    startDate: startDate,
                    endDate: endDate,
                    name: name,
                    purpose: purpose,
                    notes: notes,
                    user: user
            )
        }

        when: 'json request is sent with domain conversion'
        String jsonObject = '{"id":227, "city":"Дубай","endDate":"2018-05-17T03:00:00Z","name":"Маша","notes":"Отдых","purpose":"Отдых","startDate":"2018-05-10T03:00:00Z","user":"admin"}'
        controller.request.method = 'POST'
        controller.request.JSON = jsonObject
        controller.create()

        then: 'CREATED status code is set'
        response.status == 200
    }

    void 'Test the index action'() {
        given:

        Long id = 33L
        String name = "Миша"
        String city = "Дубай"
        Date startDate = Date.parse("YYYY-MM-DD","2018-05-10")
        Date endDate = Date.parse("YYYY-MM-DD", "2018-05-17")
        String purpose = "Отдых"
        String notes = "Пляжный4"
        String user = "admin"
        String jsonObject = '{"id":33, "city":"Дубай","endDate":"2018-05-17T03:00:00Z","name":"Маша","notes":"Отдых","purpose":"Отдых","startDate":"2018-05-10T03:00:00Z","user":"admin"}'
        String jsonObject1 = '{"id":34,"city":"Москва","endDate":"2018-04-18T03:00:00Z","name":"Максим","notes":"Заключение договора","purpose":"Командировка","startDate":"2018-04-14T03:00:00Z","user":"admin"}'
        String jsonObject2 = '{"id":35,"city":"Стамбул","endDate":"2018-04-20T03:00:00Z","name":"Анна","notes":"Расторжение договора","purpose":"Командировка","startDate":"2018-04-18T03:00:00Z","user":"jane"}'
        List<Report> reports = [new Report(JSON.parse(jsonObject)),
                                       new Report(JSON.parse(jsonObject1)),
                                       new Report(JSON.parse(jsonObject2))]

        controller.reportService = Stub(ReportService) {
            list(_) >> reports
        }

        when: 'json request is sent with domain conversion'
            controller.index()
        then: 'The model is correct'
            response.status == 200
    }


}