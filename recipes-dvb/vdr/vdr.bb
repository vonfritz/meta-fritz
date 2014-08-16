SUMMARY = "digital satellite receiver and Video Disk Recorder"
HOMEPAGE = "http://tvdr.de/"

DEPENDS = "libjpeg-turbo perl fontconfig freetype gettext libcap"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "git://projects.vdr-developer.org/vdr.git;branch=stable/2.0 \
           file://0001-add-Make.config.patch \
          "

SRCREV = "18a0976aab1fc703e346712145f3ae45474cd95d"
PV = "2.0.6"

CFLAGS_append = " -fPIC"
CXXFLAGS_append = " -fPIC"

S = "${WORKDIR}/git"

PLUGINDIR = "${libdir}/vdr/plugins"

inherit pkgconfig

do_install () {
      oe_runmake 'DESTDIR=${D}' \
                 install
}

PACKAGES_DYNAMIC += "vdr-plugin-*"

python populate_packages_prepend () {
    plugindir = d.expand('${PLUGINDIR}')
    plugindir_dbg = d.expand('${PLUGINDIR}/.debug')
    do_split_packages(d, plugindir, '^libvdr-(.*)\.so*', 'vdr-plugin-%s', 'vdr plugin %s',  extra_depends='')
    do_split_packages(d, plugindir_dbg, '^libvdr-(.*)\.so*', 'vdr-plugin-%s-dbg', 'vdr plugin %s (debug)',  extra_depends='')
}

FILES_${PN} = "${bindir}/* /var/* ${sysconfdir}/* /usr/share/*"
