import org.reporting.SecUser
import org.reporting.SecRole
import org.reporting.SecUserSecRole

class BootStrap {

    def init = { servletContext ->
        SecUser admin = new SecUser(username:'admin', password:'secret', enabled:true).save()
        SecUser john = new SecUser(username:'john', password:'secret', enabled:true).save()
        SecUser jane = new SecUser(username:'jane', password:'secret', enabled:true).save()
        SecRole roleadmin = new SecRole(authority: 'ROLE_ADMINY').save()
        SecRole rolecommon = new SecRole(authority: 'ROLE_COMMON').save()
        SecUserSecRole.create(admin, roleadmin)
        SecUserSecRole.create(jane, rolecommon)
        SecUserSecRole.create(john, rolecommon)
    }
    def destroy = {
    }
}
