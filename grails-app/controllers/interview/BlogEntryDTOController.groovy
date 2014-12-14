package interview



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BlogEntryDTOController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BlogEntryDTO.list(params), model:[blogEntryDTOInstanceCount: BlogEntryDTO.count()]
    }

    def show(BlogEntryDTO blogEntryDTOInstance) {
        respond blogEntryDTOInstance
    }

    def create() {
        respond new BlogEntryDTO(params)
    }

    @Transactional
    def save(BlogEntryDTO blogEntryDTOInstance) {
        if (blogEntryDTOInstance == null) {
            notFound()
            return
        }

        if (blogEntryDTOInstance.hasErrors()) {
            respond blogEntryDTOInstance.errors, view:'create'
            return
        }

        blogEntryDTOInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'blogEntryDTO.label', default: 'BlogEntryDTO'), blogEntryDTOInstance.id])
                redirect blogEntryDTOInstance
            }
            '*' { respond blogEntryDTOInstance, [status: CREATED] }
        }
    }

    def edit(BlogEntryDTO blogEntryDTOInstance) {
        respond blogEntryDTOInstance
    }

    @Transactional
    def update(BlogEntryDTO blogEntryDTOInstance) {
        if (blogEntryDTOInstance == null) {
            notFound()
            return
        }

        if (blogEntryDTOInstance.hasErrors()) {
            respond blogEntryDTOInstance.errors, view:'edit'
            return
        }

        blogEntryDTOInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BlogEntryDTO.label', default: 'BlogEntryDTO'), blogEntryDTOInstance.id])
                redirect blogEntryDTOInstance
            }
            '*'{ respond blogEntryDTOInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BlogEntryDTO blogEntryDTOInstance) {

        if (blogEntryDTOInstance == null) {
            notFound()
            return
        }

        blogEntryDTOInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BlogEntryDTO.label', default: 'BlogEntryDTO'), blogEntryDTOInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blogEntryDTO.label', default: 'BlogEntryDTO'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
