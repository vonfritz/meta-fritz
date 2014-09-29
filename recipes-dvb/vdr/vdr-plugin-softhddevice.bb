SUMMARY = "A software and GPU emulated HD output device plugin for VDR"
HOMEPAGE = "http://projects.vdr-developer.org/projects/plg-softhddevice"

DEPENDS = "vdr ffmpeg alsa-lib libvdpau virtual/libx11 xcb-util-wm"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://AGPL-3.0.txt;md5=c959e6f173ca1387f63fbaec5dc12f99"

SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-softhddevice.git;branch=master \ 
           "

SRCREV = "a3c0052c4b87b44679d8264c89d085fcda721a2e"
PV = "0.6.1+git${SRCPV}"
PR = "r0"

CFLAGS_append = " -fPIC -fsigned-char"
CXXFLAGS_append = " -fPIC -fsigned-char"

S = "${WORKDIR}/git"


PLUGINDIR = "${libdir}/vdr/plugins"

do_install () {
      oe_runmake 'DESTDIR=${D}' \
                 install
}

FILES_${PN} = "${PLUGINDIR}/*"
FILES_${PN}-dbg += "${PLUGINDIR}/.debug/*"
