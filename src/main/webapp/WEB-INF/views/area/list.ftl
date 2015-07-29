[@override name="title"]区域管理[/@override]
[@override name="topResources"]
    [@super /]
[/@override]

[@override name="position"]
<li><a href="[@spring.url '/area/list' /]">区域管理</a></li>
[/@override]

[@override name="subContent"]
<form class="templatemo-search-form" role="search">
    <div class="input-group">
        <button type="submit" class="fa fa-search"></button>
        <input type="text" class="form-control" placeholder="根据区域名称查找" name="name" id="srch-term">
    </div>
</form>
<div class="templatemo-content-widget no-padding">
    <div class="panel panel-default table-responsive">
        <table class="table table-striped table-bordered templatemo-user-table">
            <thead>
            <tr>
                <td>名称</td>
                <td>编号</td>
                <td colspan="3">操作</td>
            </tr>
            </thead>
            <tbody>
            [#list pagination.data as area]
            <tr>
                <td>${area.name!}</td>
                <td>${area.priority!}</td>
                <td><a href="" class="templatemo-edit-btn">编辑</a></td>
                <td><a href="" class="templatemo-edit-btn">查看</a></td>
                <td><a href="" class="templatemo-edit-btn">删除</a></td>
            </tr>
            [/#list]
            </tbody>
        </table>
    </div>
    [@mc.showPagination '/area/list?name=${area.name!}&orderWay=${area.orderWay!}' /]
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]