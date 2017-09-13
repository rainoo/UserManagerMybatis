/**
 * 调用后台单条记录删除方法
 */
function deleteOne(basePath) {
	// 把action路径改掉
	$("#mainForm").attr("action", basePath + "deleteone.action");
	// 调用submit()方法
	$("#mainForm").submit();
}

/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	if ($('input[type=checkbox]:checked').size() > 0) {
		// 把action路径改掉
		$("#mainForm").attr("action", basePath + "deletebatch.action");
		// 调用submit()方法
		$("#mainForm").submit();
	} else {
		alert("请选中要删除的用户 ");
	}
}

/**
 * 修改当前页码，调用后台从新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}