<%@ page language="java" pageEncoding="GBK" %>
	<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
		<html>

		<head>
			<title>JSP for DynaActionForm form</title>
			<script type="text/javascript">
				function checkInput() {
					if (document.userLoginForm.loginName.value == null || document.userLoginForm.loginName.value == "") {
						alert("�û�������Ϊ��");
						document.userLoginForm.loginName.focus();
						return false;
					}
					if (document.userLoginForm.pwd.value == null || document.userLoginForm.pwd.value == "") {
						alert("�û����벻��Ϊ�գ�");
						document.userLoginForm.pwd.focus();
						return false;
					}
					if (document.userLoginForm.pwd1.value == null || document.userLoginForm.pwd1.value == "") {
						alert("ȷ�����벻��Ϊ�գ�");
						document.userLoginForm.pwd1.focus();
						return false;
					}
					if (document.userLoginForm.pwd.value != document.userLoginForm.pwd1.value) {
						alert("������������벻һ�£�");
						document.userLoginForm.pwd.focus();
						return false;
					}
					if (document.userLoginForm.mail.value == null || document.userLoginForm.mail.value == "") {
						alert("�������䲻��Ϊ�գ�");
						document.userLoginForm.mail.focus();
						return false;
					}
					return true;
				}
			</script>
			<link href="images/css.css" rel="stylesheet" type="text/css">
		</head>

		<body>
			<table border="0" align="center" cellpadding="0" cellspacing="0" width="955">
				<tr>
					<td colspan="2" background="images/topNo.jpg" height="243">&nbsp;</td>
				</tr>
				<tr>
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td width="27" valign="middle">&nbsp;<img src="images/jiantou.jpg" width="15" height="17" /></td>
					<td width="928" valign="middle"><span class="STYLE1">��ǰλ�ã�</span>���û�ע��</td>
				</tr>
				<tr>
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" height="200">
						<html:form action="/reg.do" onsubmit="return checkInput()">
							<table width="600" border="0" align="center" cellpadding="0" cellspacing="1"
								bgcolor="#c2d3b0">
								<tr>
									<td height="24" colspan="3" align="center" bgcolor="#FFFFFF" class="STYLE1">${error}
									</td>
								</tr>
								<tr>
									<td width="110" bgcolor="#FFFFFF" class="td0">�û�����</td>
									<td width="266" bgcolor="#FFFFFF">&nbsp;&nbsp;
										<html:text property="loginName" />
									</td>
									<td width="220" bgcolor="#FFFFFF" class="STYLE2">&nbsp;ϵͳ��¼�ʺ�6-10λӢ���ַ�������
									</td>
								</tr>
								<tr>
									<td bgcolor="#FFFFFF" class="td0">���룺</td>
									<td bgcolor="#FFFFFF">&nbsp;&nbsp;
										<html:password property="pwd" />
									</td>
									<td bgcolor="#FFFFFF" class="STYLE2">&nbsp;��¼����6-10λӢ���ַ�������</td>
								</tr>
								<tr>
									<td bgcolor="#FFFFFF" class="td0">ȷ�����룺</td>
									<td bgcolor="#FFFFFF">&nbsp;&nbsp;
										<html:password property="pwd1" />
									</td>
									<td bgcolor="#FFFFFF" class="STYLE2">&nbsp;��֤��¼����</td>
								</tr>
								<tr>
									<td bgcolor="#FFFFFF" class="td0">�������䣺</td>
									<td bgcolor="#FFFFFF">&nbsp;&nbsp;
										<html:text property="mail" />
									</td>
									<td bgcolor="#FFFFFF" class="STYLE2">&nbsp;��������������ַ</td>
								</tr>
								<tr>
									<td height="24" colspan="3" align="center" bgcolor="#FFFFFF">
										<html:submit value="ע��" />&nbsp;&nbsp;&nbsp;&nbsp;
										<html:reset value="����" />
									</td>
								</tr>
							</table>
						</html:form>
					</td>
				</tr>
				<tr>
					<td colspan="2" background="images/bottomM.gif" height="87">&nbsp;</td>
				</tr>
			</table>
		</body>

		</html>