var sqlite = require('sqlite3');
var db = new sqlite.Database('main.db');
var moment = require('moment');

var day = moment().day("Monday").hour(0).minute(0).second(0).millisecond(0);
console.log(day);
var timestamp = moment(day).unix();
// console.log(moment(timestamp).format("DD/MM/YYYY"));

db.serialize(() => {
  for (var i = 0; i < 336; i++) {
      var stmt = db.prepare("INSERT INTO Schedule (ScheduleId,BusinessId,StartDateTime,EndDateTime) VALUES (?,?,?,?)");
      stmt.run(i+1, 1, timestamp+(30*60*i), timestamp+(30*60*(i+1)));
  }
  stmt.finalize();
});