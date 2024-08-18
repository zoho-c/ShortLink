-- set user access frequency limitation parameters
local username = KEY[1]
local timeWindow = tonumber(ARGV[1]) -- time window in seconds

local accessKey = "short-link:user-flow-risk-control:" .. username

local currentAccessCount = redis.call("INCR", accessKey)

redis.call("EXPIRE", accessKey, timeWindow)

return currentAccessCount