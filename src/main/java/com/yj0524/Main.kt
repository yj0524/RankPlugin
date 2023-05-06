package com.yj0524

import io.github.monun.kommand.*
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager
import org.bukkit.scoreboard.Team

class Main : JavaPlugin(), Listener {

    var scoreboardManager: ScoreboardManager? = null
    var scoreboard: Scoreboard? = null

    var admin: Team? = null
    var developer: Team? = null
    var staff: Team? = null
    var twitch: Team? = null
    var youtube: Team? = null
    var user: Team? = null

    override fun onEnable() {
        logger.info("Plugin Enabled")

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, Runnable {
            addTeam()
        }, 0, 1)
        loadKommand()

        Bukkit.getPluginManager().registerEvents(this, this)
    }

    override fun onDisable() {
        logger.info("Plugin Disabled")
    }

    fun addTeam() {
        scoreboardManager = Bukkit.getScoreboardManager()
        scoreboard = scoreboardManager!!.mainScoreboard

        // 팀 생성
        if (scoreboard!!.getTeam("admin") == null) {
            admin = scoreboard!!.registerNewTeam("admin")
            admin!!.setDisplayName("Admin")
            admin!!.setPrefix("§a[§rAdmin§a]§r ")
        } else {
            admin = scoreboard!!.getTeam("admin")
        }
        if (scoreboard!!.getTeam("developer") == null) {
            developer = scoreboard!!.registerNewTeam("developer")
            developer!!.setDisplayName("Developer")
            developer!!.setPrefix("§b[§rDeveloper§b]§r ")
        } else {
            developer = scoreboard!!.getTeam("developer")
        }
        if (scoreboard!!.getTeam("staff") == null) {
            staff = scoreboard!!.registerNewTeam("staff")
            staff!!.setDisplayName("Staff")
            staff!!.setPrefix("§6[§rStaff§6]§r ")
        } else {
            staff = scoreboard!!.getTeam("staff")
        }
        if (scoreboard!!.getTeam("twitch") == null) {
            twitch = scoreboard!!.registerNewTeam("twitch")
            twitch!!.setDisplayName("Twitch")
            twitch!!.setPrefix("§d[§rTwitch§d]§r ")
        } else {
            twitch = scoreboard!!.getTeam("twitch")
        }
        if (scoreboard!!.getTeam("youtube") == null) {
            youtube = scoreboard!!.registerNewTeam("youtube")
            youtube!!.setDisplayName("Youtube")
            youtube!!.setPrefix("§c[§rYoutube§c]§r ")
        } else {
            youtube = scoreboard!!.getTeam("youtube")
        }
        if (scoreboard!!.getTeam("user") == null) {
            user = scoreboard!!.registerNewTeam("user")
            user!!.setDisplayName("User")
            user!!.setPrefix("§7[§rUser§7]§r ")
        } else {
            user = scoreboard!!.getTeam("user")
        }
    }

    fun loadKommand() {
        kommand {
            register("rank") {
                requires {
                    isOp
                }
                then("set") {
                    then("admin") {
                        executes {
                            if (scoreboard!!.getEntryTeam(sender.name) != null) {
                                scoreboard!!.getEntryTeam(sender.name)!!.removeEntry(sender.name)
                            }
                            admin!!.addEntry(sender.name)
                            sender.sendMessage("당신의 랭크가 ${admin!!.prefix}(으)로 변경되었습니다.")
                        }
                        then("player" to player()) {
                            executes {
                                val player: Player by it
                                if (scoreboard!!.getEntryTeam(player.name) != null) {
                                    scoreboard!!.getEntryTeam(player.name)!!.removeEntry(player.name)
                                }
                                admin!!.addEntry(player.name)
                                sender.sendMessage("${player.name}의 랭크를 ${admin!!.prefix}(으)로 변경했습니다.")
                                player.sendMessage("당신의 랭크가 ${admin!!.prefix}(으)로 변경되었습니다.")
                            }
                        }
                    }
                    then("developer") {
                        executes {
                            if (scoreboard!!.getEntryTeam(sender.name) != null) {
                                scoreboard!!.getEntryTeam(sender.name)!!.removeEntry(sender.name)
                            }
                            developer!!.addEntry(sender.name)
                            sender.sendMessage("당신의 랭크가 ${developer!!.prefix}(으)로 변경되었습니다.")
                        }
                        then("player" to player()) {
                            executes {
                                val player: Player by it
                                if (scoreboard!!.getEntryTeam(player.name) != null) {
                                    scoreboard!!.getEntryTeam(player.name)!!.removeEntry(player.name)
                                }
                                developer!!.addEntry(player.name)
                                sender.sendMessage("${player.name}의 랭크를 ${developer!!.prefix}(으)로 변경했습니다.")
                                player.sendMessage("당신의 랭크가 ${developer!!.prefix}(으)로 변경되었습니다.")
                            }
                        }
                    }
                    then("staff") {
                        executes {
                            if (scoreboard!!.getEntryTeam(sender.name) != null) {
                                scoreboard!!.getEntryTeam(sender.name)!!.removeEntry(sender.name)
                            }
                            staff!!.addEntry(sender.name)
                            sender.sendMessage("당신의 랭크가 ${staff!!.prefix}(으)로 변경되었습니다.")
                        }
                        then("player" to player()) {
                            executes {
                                val player: Player by it
                                if (scoreboard!!.getEntryTeam(player.name) != null) {
                                    scoreboard!!.getEntryTeam(player.name)!!.removeEntry(player.name)
                                }
                                staff!!.addEntry(player.name)
                                sender.sendMessage("${player.name}의 랭크를 ${staff!!.prefix}(으)로 변경했습니다.")
                                player.sendMessage("당신의 랭크가 ${staff!!.prefix}(으)로 변경되었습니다.")
                            }
                        }
                    }
                    then("twitch") {
                        executes {
                            if (scoreboard!!.getEntryTeam(sender.name) != null) {
                                scoreboard!!.getEntryTeam(sender.name)!!.removeEntry(sender.name)
                            }
                            twitch!!.addEntry(sender.name)
                            sender.sendMessage("당신의 랭크가 ${twitch!!.prefix}(으)로 변경되었습니다.")
                        }
                        then("player" to player()) {
                            executes {
                                val player: Player by it
                                if (scoreboard!!.getEntryTeam(player.name) != null) {
                                    scoreboard!!.getEntryTeam(player.name)!!.removeEntry(player.name)
                                }
                                twitch!!.addEntry(player.name)
                                sender.sendMessage("${player.name}의 랭크를 ${twitch!!.prefix}(으)로 변경했습니다.")
                                player.sendMessage("당신의 랭크가 ${twitch!!.prefix}(으)로 변경되었습니다.")
                            }
                        }
                    }
                    then("youtube") {
                        executes {
                            if (scoreboard!!.getEntryTeam(sender.name) != null) {
                                scoreboard!!.getEntryTeam(sender.name)!!.removeEntry(sender.name)
                            }
                            youtube!!.addEntry(sender.name)
                            sender.sendMessage("당신의 랭크가 ${youtube!!.prefix}(으)로 변경되었습니다.")
                        }
                        then("player" to player()) {
                            executes {
                                val player: Player by it
                                if (scoreboard!!.getEntryTeam(player.name) != null) {
                                    scoreboard!!.getEntryTeam(player.name)!!.removeEntry(player.name)
                                }
                                youtube!!.addEntry(player.name)
                                sender.sendMessage("${player.name}의 랭크를 ${youtube!!.prefix}(으)로 변경했습니다.")
                                player.sendMessage("당신의 랭크가 ${youtube!!.prefix}(으)로 변경되었습니다.")
                            }
                        }
                    }
                    then("user") {
                        executes {
                            if (scoreboard!!.getEntryTeam(sender.name) != null) {
                                scoreboard!!.getEntryTeam(sender.name)!!.removeEntry(sender.name)
                            }
                            user!!.addEntry(sender.name)
                            sender.sendMessage("당신의 랭크가 ${user!!.prefix}(으)로 변경되었습니다.")
                        }
                        then("player" to player()) {
                            executes {
                                val player: Player by it
                                if (scoreboard!!.getEntryTeam(player.name) != null) {
                                    scoreboard!!.getEntryTeam(player.name)!!.removeEntry(player.name)
                                }
                                user!!.addEntry(player.name)
                                sender.sendMessage("${player.name}의 랭크를 ${user!!.prefix}(으)로 변경했습니다.")
                                player.sendMessage("당신의 랭크가 ${user!!.prefix}(으)로 변경되었습니다.")
                            }
                        }
                    }
                }
                then("info") {
                    executes {
                        sender.sendMessage("당신의 랭크는 ${scoreboard!!.getEntryTeam(sender.name)!!.prefix}입니다.")
                    }
                    then("player" to player()) {
                        executes {
                            val player: Player by it
                            sender.sendMessage("${player.name}의 랭크는 ${scoreboard!!.getEntryTeam(player.name)!!.prefix}입니다.")
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        if (scoreboard!!.getEntryTeam(event.player.name) == null) {
            user!!.addEntry(event.player.name)
        }
    }
}
