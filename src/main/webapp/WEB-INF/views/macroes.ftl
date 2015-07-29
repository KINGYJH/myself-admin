[#--//TODO with parameters--]
[#macro showPagination path]
<div class="tile color pagination-nice-scroll row">
    <section class="tile color col-md-12">
        [#local totalPage = (pagination.count / pagination.pageSize)?ceiling]

        [#if path?contains("?")]
            [#local basePath = path + '&pageSize=' + pagination.pageSize + '&page=']
        [#else]
            [#local basePath = path + '?pageSize=' + pagination.pageSize + '&page=']
        [/#if]

        [#if pagination.data?size > 0]
            <div class="col-md-6">
                <div class="dataTables_info">总计 ${pagination.count} 条数据, 每页显示${pagination.pageSize}条,总计 ${totalPage}页</div>
            </div>
            <div class="col-md-6">
                <ul class="pagination pagination-custom pull-right">
                    [#if pagination.page - 1 <= 0]
                        <li class="disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
                    [#else]
                        <li><a href="[@spring.url basePath + (pagination.page - 1)/]"><i class="fa fa-angle-double-left"></i></a></li>
                    [/#if]

                    [#list 1..totalPage as index]
                        [#if totalPage < 11]
                            [#if pagination.page == index]
                                <li class="active"><a href="#">${index}</a></li>
                            [#else]
                                <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                            [/#if]
                        [#else]
                            [#if (index > (pagination.page - 5)) && (index < (pagination.page + 4))]
                                [#if pagination.page == index]
                                    <li class="active"><a href="#">${index}</a></li>
                                [#else]
                                    <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                                [/#if]
                            [/#if]
                        [/#if]
                    [/#list]

                    [#if pagination.page == totalPage]
                        <li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
                    [#else]
                        <li><a href="[@spring.url basePath + (pagination.page + 1)/]"><i class="fa fa-angle-double-right"></i></a></li>
                    [/#if]
                </ul>
            </div>
        [#else]
            <div class="col-md-2 col-md-offset-5">
                <Strong>没有查询到数据</Strong>
            </div>
        [/#if]
</div>
[/#macro]