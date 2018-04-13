import org.reporting.SecUser
import org.reporting.SecRole
import org.reporting.SecUserSecRole
import reporting.Employer

class BootStrap {

    def init = { servletContext ->
        if (Employer.list().empty) {
            Employer admin = new Employer (name: 'admin', password: 'secret')
            Employer simpleuser = new Employer (name: 'user', password: 'secret')
            Employer.saveAll([admin,simpleuser])
        }
        Employer.list().each {
            SecUser user = new SecUser(username: it.name, password: it.password, enabled:true).save()
            String rolename
            if (it.name=='admin')
                rolename = 'ROLE_ADMINY'
            else
                rolename = 'ROLE_COMMON'
            SecRole role = new SecRole(authority: rolename).save()
            SecUserSecRole.create(user, role)
        }
    }
    def destroy = {
    }
}
