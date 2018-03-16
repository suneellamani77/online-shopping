<p class="lead">Shop Name</p>
          <div class="list-group">
          <!-- 
          	 <a href="#" class="list-group-item">Category1</a>
            <a href="#" class="list-group-item">Category 2</a>
            <a href="#" class="list-group-item">Category 3</a>
             -->
	<c:forEach items="${categories}" var="c1">
	<a href="${contextRoot}/show/category/${c1.id}/products" class="list-group-item" id="a_${c1.name}">${c1.name}</a>
	</c:forEach>
            
          </div>
