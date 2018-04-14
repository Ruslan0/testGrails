package reporting

class Employer {
    String login     //login
    String password
    static belongsTo = Report
    static hasMany = [reports: Report]
    static constraints = {
        login blank: false, unique: true
    }
}
