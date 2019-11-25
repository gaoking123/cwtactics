stjs.ns("cwt"),cwt.DialogDesc=function(){},stjs.extend(cwt.DialogDesc,null,[],function(n,t){t.id=null,t.title=null,t.text=null},{text:{name:"Array",arguments:[null]}}),stjs.ns("cwt"),cwt.EventHandler=function(){},stjs.extend(cwt.EventHandler,null,[],function(n){n.onEvent=function(n,t){$(window.document).on(n,t)},n.fireEvent=function(n,t){$(window.document).trigger(n,t)}},{}),stjs.ns("cwt"),cwt.ContentPanelDesc=function(){},stjs.extend(cwt.ContentPanelDesc,null,[],function(n,t){n.ChangelogDesc=function(){},stjs.extend(cwt.ContentPanelDesc.ChangelogDesc,null,[],function(n,t){t.NEW=null,t.CHANGED=null,t.FIXED=null},{NEW:{name:"Array",arguments:[null]},CHANGED:{name:"Array",arguments:[null]},FIXED:{name:"Array",arguments:[null]}}),t.header=null,t.version=null,t.subHeaderT=null,t.subHeaderB=null,t.text=null,t.img=null,t.link=null,t.log=null},{text:{name:"Array",arguments:[null]},log:"cwt.ContentPanelDesc.ChangelogDesc"}),stjs.ns("cwt"),cwt.Log=function(){},stjs.extend(cwt.Log,null,[],function(n){n.fine=function(n){console.log("INFO: "+n)},n.warn=function(n){console.log("WARN: "+n)},n.error=function(n){console.log("ERROR: "+n)}},{})
var ErrorHandler=function(){}
stjs.extend(ErrorHandler,null,[],function(n){n.doErrorHandling=function(n){window.document.writeln("An error occurred.<br/><br/>"+n+"<br/><br/><br/>Please contact us about this fault (<a href='mailto:ctomni231@gmail.com'>ctomni231@gmail.com</a>).")}},{})
var DomHelper=function(){}
stjs.extend(DomHelper,null,[],function(n){n.createLink=function(){return window.document.createElement("a")},n.createList=function(){return window.document.createElement("ul")},n.createListEntry=function(){return window.document.createElement("li")}},{}),stjs.ns("cwt"),cwt.NavBarLinkDesc=function(){},stjs.extend(cwt.NavBarLinkDesc,null,[],function(n,t){t.id=null,t.link=null,t.label=null,t.title=null,t.sameWindow=!1,t.isDialog=!1},{}),stjs.ns("cwt"),cwt.BloggerPostsDesc=function(){},stjs.extend(cwt.BloggerPostsDesc,null,[],function(n,t){n.BloggerPostsItemDesc=function(){},stjs.extend(cwt.BloggerPostsDesc.BloggerPostsItemDesc,null,[],function(n,t){t.title=null,t.url=null,t.published=null},{}),t.items=null},{items:{name:"Array",arguments:["cwt.BloggerPostsDesc.BloggerPostsItemDesc"]}}),stjs.ns("cwt"),cwt.NewsDesc=function(){},stjs.extend(cwt.NewsDesc,null,[],function(n,t){n.NewsItemDesc=function(){},stjs.extend(cwt.NewsDesc.NewsItemDesc,null,[],function(n,t){t.title=null,t.url=null,t.date=null},{}),t.news=null},{news:{name:"Array",arguments:["cwt.NewsDesc.NewsItemDesc"]}}),stjs.ns("cwt"),cwt.GithubMilestoneDesc=function(){},stjs.extend(cwt.GithubMilestoneDesc,null,[],null,{}),stjs.ns("cwt"),cwt.Dialog=function(n){cwt.Log.fine("Construct dialog "+n.id),this.id=n.id
var t=this.buildOptions(n)
$(cwt.Dialog.SECTION_NAME).append(this.buildContent(n)),$("#"+this.id).dialog(t)},stjs.extend(cwt.Dialog,null,[],function(n,t){n.SECTION_NAME="#dialogs",t.id=null,t.buildContent=function(n){var t=window.document.createElement("div")
t.id=n.id
for(var e=0;e<n.text.length;e++)$(t).append("<p>"+n.text[e]+"</p>")
return t},t.buildOptions=function(n){var t=this,e={}
return e.modal=!0,e.autoOpen=!1,e.closeOnEscape=!1,e.resizable=!1,e.draggable=!0,e.width=500,e.title=n.title,e.show={},e.show.effect="fade",e.show.duration=250,e.hide={},e.hide.effect="fade",e.hide.duration=250,e.buttons={},e.buttons.Ok=function(){t.close()},e},t.show=function(){cwt.Log.fine("Opening dialog "+this.id),$("#"+this.id).dialog("open")},t.close=function(){cwt.Log.fine("Closing dialog "+this.id),$("#"+this.id).dialog("close")}},{}),stjs.ns("cwt"),cwt.NavBarLink=function(n){cwt.Log.fine("Generate navigation bar link "+n.id),this.ref="#"+n.id,this.buildElement(n)},stjs.extend(cwt.NavBarLink,null,[],function(n,t){n.SECTION_NAME="#navbar",t.ref=null,t.buildElement=function(n){var t=DomHelper.createLink()
1==n.isDialog?(t.href="#",t.onclick=function(){return cwt.EventHandler.fireEvent("openDialog",[n.link]),!1}):(t.href=n.link,1!=n.sameWindow&&(t.target="_blank")),t.title=n.label,t.innerHTML=n.label,$(cwt.NavBarLink.SECTION_NAME).append(t)},t.click=function(){$(this.ref).click()}},{}),stjs.ns("cwt"),cwt.ContentPanel=function(n){this.buildElement(n)},stjs.extend(cwt.ContentPanel,null,[],function(n,t){n.SECTION_NAME="#content",n.BLOGGER_GRAB_URL="https://www.googleapis.com/blogger/v3/blogs/8771777547738195480/posts?fetchBodies=false&fetchImages=false&maxResults=4&key=AIzaSyBeLzkUGTUFQ0z5yEGeuF4c0d0i5Vhgc1Y",t.buildElement=function(n){var t
s=''
var d=new Date()
if(d.getMonth()==0){s='cwThrowback'}else if(d.getMonth()==9){s='cwSpooky'}else if(d.getMonth()==11){s='cwHoliday'}else{s='cwAdvance'}
t="<p class='cwtHeaderImage'>",t+="<img src='images/",t+=s,t+=".png' />",t+="</p>",$(cwt.ContentPanel.SECTION_NAME).append(t),t="<table class='prictureAndNewsTable' ><tbody><tr>",t+="<td><img class='currentVersionImage' src='"+n.img+"'></td>",t+="<td class='newsBlock' ><img class='currentNewsWaitingImage' src='images/wait.gif'/></td>",t+="</tr></tbody></table>",$(cwt.ContentPanel.SECTION_NAME).append(t),$(cwt.ContentPanel.SECTION_NAME).append("<p class='uibuttonHolder'><a target='_blank' href='"+n.link+"' class='uibutton'>Play v. "+n.version+"</a></p>"),t="<div class='currentVersionText'>"
for(var e=0;e<n.text.length;e++)t+="<p>"+n.text[e]+"</p>"
t+="</div>",$(cwt.ContentPanel.SECTION_NAME).append(t),$(cwt.ContentPanel.SECTION_NAME).append("<p class='currentVersionChangelogHeader'>Changelog</p>"),t="<table class='currentVersionChangelog'><tbody>"
for(var e=0;e<n.log.NEW.length;e++)t+="<tr><td class='new'>NEW: </td><td>"+n.log.NEW[e]+"</td></tr>"
for(var e=0;e<n.log.CHANGED.length;e++)t+="<tr><td class='changed'>CHANGED: </td><td>"+n.log.CHANGED[e]+"</td></tr>"
for(var e=0;e<n.log.FIXED.length;e++)t+="<tr><td class='fixed'>FIXED: </td><td>"+n.log.FIXED[e]+"</td></tr>"
t+="</tbody></table>",$(cwt.ContentPanel.SECTION_NAME).append(t),this.buildNews($(".newsBlock"))},t.buildNews=function(n){cwt.Log.fine("Loading blogger posts")
var t=function(t){for(var e=$(DomHelper.createList()),a=0;a<t.news.length;a++){var l=t.news[a],o=$(DomHelper.createListEntry())
o.html("<a target='_blank' title='Open article' href='"+l.url+"' >"+moment(l.date,"YYYY-MM-DD HH:mm:ss.SSS-Z,ZZ").fromNow()+"<br/><span><i>"+l.title+"</i></span></a>"),e.append(o)}$(".currentNewsWaitingImage").remove(),n.append(e)}
void 0==localStorage.newsEndDate||moment().isAfter(localStorage.newsEndDate)?$.get(cwt.ContentPanel.BLOGGER_GRAB_URL,function(n){try{var e=n,a={}
a.news=[]
for(var l=0;l<e.items.length;l++){var o=e.items[l],i={}
i.date=o.published,i.title=o.title,i.url=o.url,a.news.push(i)}localStorage.newsEndDate=moment().add("m",360),localStorage.newsData=JSON.stringify(a),t(a)}catch(s){ErrorHandler.doErrorHandling(s)}}):t(JSON.parse(localStorage.newsData))}},{}),stjs.ns("cwt"),cwt.DataLoader=function(){},stjs.extend(cwt.DataLoader,null,[],function(n){n.loadDialogs=function(n){cwt.Log.fine("Loading dialogs"),$.get("data/dialogs.json",function(t){try{for(var e={},a="string"==typeof t?JSON.parse(t):t,l=0;l<a.length;l++)e[a[l].id]=new cwt.Dialog(a[l])
n(e)}catch(o){ErrorHandler.doErrorHandling(o)}})},n.loadContentPanel=function(n){cwt.Log.fine("Loading content panel"),$.get("data/content.json",function(t){try{var e="string"==typeof t?JSON.parse(t):t
n(new cwt.ContentPanel(e))}catch(a){ErrorHandler.doErrorHandling(a)}})},n.loadNavigationBar=function(n){cwt.Log.fine("Loading navigation bar"),$.get("data/navigation.json",function(t){try{for(var e={},a="string"==typeof t?JSON.parse(t):t,l=0;l<a.length;l++){var o=a[l]
e[o.id]=new cwt.NavBarLink(o)}n(e)}catch(i){ErrorHandler.doErrorHandling(i)}})}},{}),stjs.ns("cwt"),cwt.WebPage=function(){},stjs.extend(cwt.WebPage,null,[],function(n){n.navigationBar=null,n.mainContent=null,n.dialogs=null,n.main=function(){cwt.Log.fine("Initializing webpage"),window.document.title="Custom Wars: Tactics",cwt.WebPage.loadStuff(),cwt.WebPage.registerEvents()},n.registerEvents=function(){cwt.EventHandler.onEvent("openDialog",function(n,t){cwt.WebPage.dialogs[t].show()})},n.loadStuff=function(){var n=[]
n.push(function(n){cwt.DataLoader.loadDialogs(function(t){cwt.WebPage.dialogs=t,n()})}),n.push(function(n){cwt.DataLoader.loadContentPanel(function(t){cwt.WebPage.mainContent=t,n()})}),n.push(function(n){cwt.DataLoader.loadNavigationBar(function(t){cwt.WebPage.navigationBar=t,n()})})
var t=function(){cwt.Log.fine("Webpage initialized"),$("body").css("display","")}
R.series(n,t)}},{navigationBar:{name:"Map",arguments:[null,"cwt.NavBarLink"]},mainContent:"cwt.ContentPanel",dialogs:{name:"Map",arguments:[null,"cwt.Dialog"]}}),stjs.mainCallDisabled||cwt.WebPage.main()
