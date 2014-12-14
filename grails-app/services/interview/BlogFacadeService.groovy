package interview

import java.util.List;

import grails.transaction.Transactional

@Transactional
class BlogFacadeService implements BlogFacade {

    def serviceMethod() {

    }

	@Override
	public List<BlogEntryDTO> getRecentEntries(int n) {
		// TODO 这里不能返回 list 类型转换出错

	
		def blogs = BlogEntryDTO.list(offset:n, max:20)
		
		return blogs;
	}

	@Override
	public void publish(BlogEntryDTO entry) {
		System.out.println("title is "+entry.title)
		if (entry == null) {
			return
		}

		entry.save flush:true
		
	}
	

}
