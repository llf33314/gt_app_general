navigator.serviceWorker&&navigator.serviceWorker.register('./service-worker.js?v=20171206085744').then(function(){navigator.serviceWorker.addEventListener('message',function(e){if(e.data==='sw.update'){setTimeout(function(){return location.reload()},16)}})});